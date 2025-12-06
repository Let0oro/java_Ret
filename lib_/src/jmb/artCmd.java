package jmb;

import org.w3c.dom.ranges.RangeException;

/**
 * ArtCmd - ASCII Art Library inspired by p5.js/Processing
 * Provides drawing functions for creating ASCII art in the terminal
 * using familiar Processing/p5.js API patterns.
 * Built on top of the cmd ANSI escape codes library.
 */
public class artCmd {
    private final int width;
    private final int height;
    private final char[][] buffer;
    private final int[] colorBuffer;
    private final int[] styleBuffer;
    private int currentX = 0;
    private int currentY = 0;
    private int currentFgColor = cmd.WHITE;
    private int currentBgColor = cmd.BG_BLACK;
    private int currentStyle = 0;
    private char drawChar = '█';
    private char bgChar = ' ';

    // ============================================
    // ANIMATION STATE & CONTROL
    // ============================================
    private Thread animationThread;
    private volatile boolean isRunning = false;
    private final int frameRate = 60;
    private int frameCount = 0;
    private long animationStartTime = 0;
    private long lastFrameTime = 0;
    private double deltaTime = 0;

    // Control panel settings
    private boolean showControls = false;
    private long loopDuration = 0;
    private long loopStartTime = 0;
    private volatile boolean paused = false;
    private long pauseTime = 0;

    // ============================================
    // INITIALIZATION
    // ============================================

    /**
     * Create a new ASCII art canvas with default settings
     * @param width canvas width in characters
     * @param height canvas height in lines
     */
    public artCmd(int width, int height) {
        this(width, height, false, 10000);
    }

    /**
     * Create a new ASCII art canvas with control panel
     * @param width canvas width in characters
     * @param height canvas height in lines
     * @param showControls whether to show control panel overlay
     */
    public artCmd(int width, int height, boolean showControls) {
        this(width, height, showControls, 10000);
    }

    /**
     * Create a new ASCII art canvas with control panel and loop duration
     * @param width canvas width in characters
     * @param height canvas height in lines
     * @param showControls whether to show control panel overlay
     * @param loopDurationMs duration of animation loop in milliseconds (0 = infinite)
     */
    public artCmd(int width, int height, boolean showControls, long loopDurationMs) {
//        if (loopDurationMs < 10000) throw new RangeException((short) 1, "The loopDurationMs cant be lower than 10000");
        if (loopDurationMs < 10000) loopDurationMs = 10000;
        this.width = width;
        this.height = height;
        this.buffer = new char[height][width];
        this.colorBuffer = new int[height * width];
        this.styleBuffer = new int[height * width];
        this.showControls = showControls;
        this.loopDuration = loopDurationMs;
        background(cmd.BLACK);
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    // ============================================
    // BASIC DRAWING FUNCTIONS
    // ============================================

    /**
     * Set the background color of the canvas (similar to background() in p5.js)
     * @param color ANSI color code
     */
    public void background(int color) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                buffer[i][j] = bgChar;
                colorBuffer[i * width + j] = color;
                styleBuffer[i * width + j] = 0;
            }
        }
        this.currentBgColor = color;
    }

    /**
     * Clear the canvas with a specific character
     * @param character character to fill with
     */
    public void clear(char character) {
        this.bgChar = character;
        background(currentBgColor);
    }

    /**
     * Set the foreground color (similar to fill() in p5.js)
     * @param color ANSI color code
     */
    public void fill(int color) {
        this.currentFgColor = color;
    }

    /**
     * Set the drawing character (similar to stroke() but for ASCII)
     * @param character character to draw with
     */
    public void stroke(char character) {
        this.drawChar = character;
    }

    /**
     * Set text style (bold, underline, etc.)
     * @param style ANSI style code
     */
    public void textStyle(int style) {
        this.currentStyle = style;
    }

    /**
     * Reset all drawing settings to defaults
     */
    public void resetStyle() {
        this.currentFgColor = cmd.WHITE;
        this.currentBgColor = cmd.BG_BLACK;
        this.currentStyle = 0;
        this.drawChar = '█';
    }

    // ============================================
    // CURSOR/POSITION FUNCTIONS
    // ============================================

    /**
     * Move cursor to position (similar to cursor() in p5.js)
     * @param x x-coordinate (0-based)
     * @param y y-coordinate (0-based)
     */
    public void cursor(int x, int y) {
        this.currentX = constrain(x, 0, width - 1);
        this.currentY = constrain(y, 0, height - 1);
    }

    /**
     * Get current X position
     */
    public int cursorX() {
        return currentX;
    }

    /**
     * Get current Y position
     */
    public int cursorY() {
        return currentY;
    }

    /**
     * Constrain a value between min and max
     */
    private int constrain(int value, int min, int max) {
        return value < min ? min : Math.min(value, max);
    }

    // ============================================
    // DRAWING PRIMITIVES
    // ============================================

    /**
     * Draw a point at current position
     */
    public void point() {
        point(currentX, currentY);
    }

    /**
     * Draw a point at (x, y)
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void point(int x, int y) {
        if (isInBounds(x, y)) {
            buffer[y][x] = drawChar;
            colorBuffer[y * width + x] = currentFgColor;
            styleBuffer[y * width + x] = currentStyle;
        }
    }

    /**
     * Check if coordinates are within bounds
     */
    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    /**
     * Draw a horizontal line
     * @param x starting x
     * @param y y-coordinate
     * @param length length of line
     */
    public void lineH(int x, int y, int length) {
        for (int i = 0; i < length; i++) {
            point(x + i, y);
        }
    }

    /**
     * Draw a vertical line
     * @param x x-coordinate
     * @param y starting y
     * @param length length of line
     */
    public void lineV(int x, int y, int length) {
        for (int i = 0; i < length; i++) {
            point(x, y + i);
        }
    }

    /**
     * Draw a line from (x1, y1) to (x2, y2) using Bresenham's algorithm
     * @param x1 starting x
     * @param y1 starting y
     * @param x2 ending x
     * @param y2 ending y
     */
    public void line(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        int x = x1;
        int y = y1;

        while (true) {
            point(x, y);
            if (x == x2 && y == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x += sx;
            }
            if (e2 < dx) {
                err += dx;
                y += sy;
            }
        }
    }

    /**
     * Draw a rectangle (outline only)
     * @param x top-left x
     * @param y top-left y
     * @param w width
     * @param h height
     */
    public void rect(int x, int y, int w, int h) {
        lineH(x, y, w);
        lineH(x, y + h - 1, w);
        lineV(x, y, h);
        lineV(x + w - 1, y, h);
    }

    /**
     * Draw a filled rectangle
     * @param x top-left x
     * @param y top-left y
     * @param w width
     * @param h height
     */
    public void rectFilled(int x, int y, int w, int h) {
        for (int i = 0; i < h; i++) {
            lineH(x, y + i, w);
        }
    }

    /**
     * Draw a circle (approximation using ASCII)
     * @param x center x
     * @param y center y
     * @param radius radius
     */
    public void circle(int x, int y, int radius) {
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if (i * i + j * j >= radius * radius - radius &&
                        i * i + j * j <= radius * radius + radius) {
                    point(x + i, y + j);
                }
            }
        }
    }

    /**
     * Draw a filled circle
     * @param x center x
     * @param y center y
     * @param radius radius
     */
    public void circleFilled(int x, int y, int radius) {
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if (i * i + j * j <= radius * radius) {
                    point(x + i, y + j);
                }
            }
        }
    }

    /**
     * Draw text at current cursor position
     * @param text text to draw
     */
    public void text(String text) {
        text(text, currentX, currentY);
    }

    /**
     * Draw text at specific position
     * @param text text to draw
     * @param x x position
     * @param y y position
     */
    public void text(String text, int x, int y) {
        for (int i = 0; i < text.length(); i++) {
            if (x + i < width) {
                point(x + i, y);
                buffer[y][x + i] = text.charAt(i);
            }
        }
    }

    // ============================================
    // ANIMATION STATE QUERIES
    // ============================================

    /**
     * Obtiene el número de frame actual (comenzando desde 0)
     * Útil para lógica basada en frames
     */
    public int getFrameCount() {
        return frameCount;
    }

    /**
     * Obtiene el tiempo transcurrido en segundos desde que comenzó la animación
     * Útil para movimientos suaves basados en tiempo
     */
    public double getElapsedTime() {
        if (!isRunning && animationStartTime == 0) return 0;
        return (System.currentTimeMillis() - animationStartTime) / 1000.0;
    }

    /**
     * Obtiene el delta time (tiempo desde el último frame) en segundos
     * Útil para movimiento frame-rate independiente
     */
    public double getDeltaTime() {
        return deltaTime;
    }

    /**
     * Obtiene los FPS actuales (promedio)
     */
    public double getActualFrameRate() {
        if (animationStartTime == 0) return 0;
        double totalTime = (System.currentTimeMillis() - animationStartTime) / 1000.0;
        if (totalTime == 0) return 0;
        return frameCount / totalTime;
    }

    /**
     * Obtiene el estado de la animación
     */
    public boolean isAnimationRunning() {
        return isRunning && !paused;
    }

    /**
     * Obtiene si la animación está pausada
     */
    public boolean isAnimationPaused() {
        return paused;
    }

    /**
     * Obtiene el tiempo restante en el bucle (en ms), o -1 si es infinito
     */
    public long getRemainingLoopTime() {
        if (loopDuration <= 0) return -1;
        long elapsed = System.currentTimeMillis() - loopStartTime;
        return Math.max(0, loopDuration - elapsed);
    }

    /**
     * Obtiene el progreso del bucle como porcentaje (0-100)
     */
    public double getLoopProgress() {
        if (loopDuration <= 0) return 0;
        long elapsed = System.currentTimeMillis() - loopStartTime;
        return Math.min(100, (elapsed * 100.0) / loopDuration);
    }

    /**
     * Reinicia los contadores de animación
     */
    public void resetAnimationCounters() {
        frameCount = 0;
        animationStartTime = System.currentTimeMillis();
        lastFrameTime = animationStartTime;
        loopStartTime = animationStartTime;
    }

    // ============================================
    // ANIMATION CONTROL
    // ============================================

    /**
     * Inicia un bucle de animación continuo (similar a draw() en Processing)
     * @param drawFunction función que se ejecuta cada frame
     */
    public void startAnimation(DrawLoop drawFunction) {
        if (isRunning) {
            System.err.println("Animation already running");
            return;
        }

        this.isRunning = true;
        this.paused = false;
        this.frameCount = 0;
        this.animationStartTime = System.currentTimeMillis();
        this.loopStartTime = animationStartTime;
        this.lastFrameTime = animationStartTime;

        animationThread = new Thread(() -> {
            long frameTime = 1000 / frameRate; // ms por frame

            while (isRunning) {
                long frameStart = System.currentTimeMillis();

                // Verificar si se alcanzó la duración del bucle
                if (loopDuration > 0 && frameStart - loopStartTime >= loopDuration) {
                    isRunning = false;
                    break;
                }

                try {
                    // Si está pausado, no procesar pero mantener el thread activo
                    if (!paused) {
                        // Calcular delta time
                        deltaTime = (frameStart - lastFrameTime) / 1000.0;
                        lastFrameTime = frameStart;

                        // Ejecutar función de dibujo
                        drawFunction.draw(artCmd.this);

                        // Renderizar el buffer
                        if (showControls) {
                            renderWithControls();
                        } else {
                            display();
                        }

                        frameCount++;
                    } else {
                        // Mientras está pausado, solo renderizar sin incrementar frame count
                        if (showControls) {
                            renderWithControls();
                        } else {
                            display();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    isRunning = false;
                    break;
                }

                // Limitar frame rate
                long elapsed = System.currentTimeMillis() - frameStart;
                long sleepTime = frameTime - elapsed;

                if (sleepTime > 0) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        isRunning = false;
                        break;
                    }
                }
            }
        });

        animationThread.setDaemon(true);
        animationThread.start();
    }

    /**
     * Detiene la animación de forma segura
     */
    public void stopAnimation() {
        if (!isRunning) return;

        isRunning = false;
        paused = false;
        if (animationThread != null) {
            try {
                animationThread.join(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Pausa la animación temporalmente
     */
    public void pauseAnimation() {
        if (!isRunning) return;
        paused = true;
        pauseTime = System.currentTimeMillis();
    }

    /**
     * Reanuda la animación después de una pausa
     */
    public void resumeAnimation() {
        if (!isRunning || !paused) return;
        paused = false;

        // Ajustar tiempos para compensar la pausa
        long pauseDuration = System.currentTimeMillis() - pauseTime;
        animationStartTime += pauseDuration;
        loopStartTime += pauseDuration;
        lastFrameTime = System.currentTimeMillis();
    }

    // ============================================
    // RENDERING
    // ============================================

    /**
     * Renderiza el buffer actual en pantalla
     * Se llama automáticamente en el bucle de animación
     */
    public void display() {
        System.out.print(cmd.moveHome);
        System.out.print(cmd.eraseScreen);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int index = y * width + x;
                int color = colorBuffer[index];
                int style = styleBuffer[index];

                // Construir código ANSI con color y estilo
                String formatted = cmd.b(
                        cmd.FORMAT,
                        String.valueOf(color) + cmd.SEPARATOR + String.valueOf(style)
                );
                System.out.print(formatted);
                System.out.print(buffer[y][x]);
            }
            System.out.println();
        }
        System.out.print(cmd.resetAll);
        System.out.flush();
    }

    /**
     * Renderiza el buffer con panel de control
     */
    private void renderWithControls() {
        System.out.print(cmd.moveHome);
        System.out.print(cmd.eraseScreen);

        // Renderizar canvas principal
        int controlHeight = 5;
        int canvasHeight = height - controlHeight;

        for (int y = 0; y < canvasHeight; y++) {
            for (int x = 0; x < width; x++) {
                int index = y * width + x;
                int color = colorBuffer[index];
                int style = styleBuffer[index];

                String formatted = cmd.b(
                        cmd.FORMAT,
                        String.valueOf(color) + cmd.SEPARATOR + String.valueOf(style)
                );
                System.out.print(formatted);
                System.out.print(buffer[y][x]);
            }
            System.out.println();
        }

        // Renderizar panel de control
        System.out.print(cmd.resetAll);
        renderControlPanel(canvasHeight, controlHeight);
        System.out.flush();
    }

    /**
     * Renderiza el panel de control
     */
    private void renderControlPanel(int startY, int height) {
        // Línea separadora
        int y = startY;
        System.out.print(cmd.moveAbsolute(y + 1, 1));
        System.out.print(cmd.b(cmd.FORMAT, String.valueOf(cmd.WHITE)));
        for (int x = 0; x < width; x++) {
            System.out.print("─");
        }

        // Información de estado
        y = startY + 1;
        System.out.print(cmd.moveAbsolute(y + 1, 1));
        String status = paused ? "[PAUSED]" : "[RUNNING]";
        String frameInfo = String.format("Frame: %-6d | FPS: %6.1f | %s",
                frameCount, getActualFrameRate(), status);
        System.out.print(frameInfo);

        // Información de tiempo
        y = startY + 2;
        System.out.print(cmd.moveAbsolute(y + 1, 1));
        String timeInfo = String.format("Time: %.2fs", getElapsedTime());
        if (loopDuration > 0) {
            timeInfo += String.format(" | Progress: %.1f%% | Remaining: %.1fs",
                    getLoopProgress(), getRemainingLoopTime() / 1000.0);
        }
        System.out.print(timeInfo);

        // Controles disponibles
        y = startY + 3;
        System.out.print(cmd.moveAbsolute(y + 1, 1));
        System.out.print(cmd.b(cmd.FORMAT, String.valueOf(cmd.BRIGHT_BLACK)));
        System.out.print("Controls: SPACE=Pause | Q=Quit | R=Reset");

        // Resetear color
        System.out.print(cmd.resetAll);
    }

    /**
     * Renderiza una sola vez sin animación (útil para debugging)
     */
    public void displayOnce() {
        System.out.print(cmd.moveHome);
        System.out.print(cmd.eraseScreen);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int index = y * width + x;
                int color = colorBuffer[index];
                int style = styleBuffer[index];

                String formatted = cmd.b(
                        cmd.FORMAT,
                        String.valueOf(color) + cmd.SEPARATOR + String.valueOf(style)
                );
                System.out.print(formatted);
                System.out.print(buffer[y][x]);
            }
            System.out.println();
        }
        System.out.print(cmd.resetAll);
        System.out.flush();
    }

    /**
     * Interface funcional para el bucle draw de animación
     * Similar a la función draw() de Processing
     */
    @FunctionalInterface
    public interface DrawLoop {
        void draw(artCmd canvas);
    }
}
