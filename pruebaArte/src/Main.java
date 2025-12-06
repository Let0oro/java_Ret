import jmb.artCmd;
import jmb.cmd;

public class Main {
    static class Ball {
        double x, y;
        double vx, vy;
        int radius;
        int color;
        double mass;

        Ball(double x, double y, double vx, double vy, int radius, int color) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            this.radius = radius;
            this.color = color;
            this.mass = radius * radius;
        }

        void update(double dt, int width, int height, double gravity, double friction) {
            vy += gravity * dt;

            x += vx * dt;
            y += vy * dt;

            // Colisión con bordes
            if (x - radius < 1) {
                x = 1 + radius;
                vx = Math.abs(vx) * friction;
            }
            if (x + radius > width - 1) {
                x = width - 1 - radius;
                vx = -Math.abs(vx) * friction;
            }

            if (y - radius < 1) {
                y = 1 + radius;
                vy = Math.abs(vy) * friction;
            }
            if (y + radius > height - 6) {
                y = height - 6 - radius;
                vy = -Math.abs(vy) * friction;
            }
        }

        boolean collidesWith<T>(T other) {
            double dx = other.x - this.x;
            double dy = other.y - this.y;
            double dist = Math.sqrt(dx * dx + dy * dy);
            return dist < this.radius + other.radius;
        }

        void collideWith(Ball other) {
            // Colisión elástica simple
            double dx = other.x - this.x;
            double dy = other.y - this.y;
            double dist = Math.sqrt(dx * dx + dy * dy);

            if (dist == 0) return;

            // Normalizar
            dx /= dist;
            dy /= dist;

            // Velocidad relativa
            double dvx = other.vx - this.vx;
            double dvy = other.vy - this.vy;

            // Velocidad en la dirección de colisión
            double dvDist = dvx * dx + dvy * dy;

            if (dvDist >= 0) return; // Se están separando

            // Intercambiar velocidades en la dirección de colisión
            double impulse = dvDist / (this.mass + other.mass);

            this.vx += impulse * other.mass * dx;
            this.vy += impulse * other.mass * dy;
            other.vx -= impulse * this.mass * dx;
            other.vy -= impulse * this.mass * dy;

            // Separar pelotas para evitar overlap
            double overlap = this.radius + other.radius - dist;
            double separation = overlap / 2 + 0.1;
            this.x -= separation * dx;
            this.y -= separation * dy;
            other.x += separation * dx;
            other.y += separation * dy;
        }

        void draw(artCmd c) {
            c.fill(color);
            c.circleFilled((int) x, (int) y, radius);
        }
    }

    public static void main(String[] args) {
        artCmd canvas = new artCmd(80, 24, true, 0);

        Ball[] balls = {
                new Ball(15, 5, 10, 2, 2, cmd.BRIGHT_RED),
                new Ball(65, 5, -10, 2, 2, cmd.BRIGHT_GREEN),
                new Ball(40, 15, 0, -3, 1, cmd.BRIGHT_YELLOW),
                new Ball(30, 3, 8, 1, 1, cmd.BRIGHT_MAGENTA),
                new Ball(50, 8, -6, 0, 2, cmd.BRIGHT_CYAN),
        };

        double gravity = 12;
        double friction = 0.94;

        canvas.startAnimation(c -> {
            c.background(cmd.BLACK);

            // Actualizar pelotas
            for (Ball ball : balls) {
                ball.update(c.getDeltaTime(), c.getWidth(), c.getHeight(), gravity, friction);
            }

            // Detectar colisiones entre pelotas
            for (int i = 0; i < balls.length; i++) {
                for (int j = i + 1; j < balls.length; j++) {
                    if (balls[i].collidesWith(balls[j])) {
                        balls[i].collideWith(balls[j]);
                    }
                }
            }

            // Dibujar pelotas
            for (Ball ball : balls) {
                ball.draw(c);
            }

            // Información
            c.fill(cmd.WHITE);
            c.text("Pelotas: " + balls.length + " | Colisiones activas", 2, 2);
        });

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            canvas.stopAnimation();
        }
    }
}
