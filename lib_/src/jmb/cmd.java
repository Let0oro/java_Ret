package jmb;

import java.util.Arrays;

/**
 * ANSI Escape Codes Terminal Control Library
 *
 * Provides methods to control terminal cursor, erase content, and apply colors/formats.
 */
public class cmd {
    static final char ESC = '\033';

    // ============================================
    // FLAG CHARACTERS
    // ============================================
    static final String MOV_ABS = "H";
    static final String MOV_UP = "A";
    static final String MOV_DOWN = "B";
    static final String MOV_RIGHT = "C";
    static final String MOV_LEFT = "D";
    static final String MOV_NEXT_BEG_LINE = "E";
    static final String MOV_PREV_BEG_LINE = "F";
    static final String MOV_ABS_COL = "G";
    static final String MOV_ONE_UP_SCROLL = "M";

    static final String FORMAT = "m";
    static final String ER_SCREEN = "J";
    static final String ER_LINE = "K";
    static final String REQ = "n";
    static final String SAVE_SCO = "s";
    static final String RESTORES_SCO = "u";

    static final String SEPARATOR = ";";

    // ============================================
    // FLAG NUMBERS
    // ============================================
    static final String END = "0";
    static final String BEGIN = "1";
    static final String ALL = "2";
    static final String SAVED = "3";
    static final String SAVE_DEC = "7";
    static final String RESTORES_DEC = "8";

    // ============================================
    // FOREGROUND COLORS
    // ============================================
    public static final int BLACK = 30;
    public static final int RED = 31;
    public static final int GREEN = 32;
    public static final int YELLOW = 33;
    public static final int BLUE = 34;
    public static final int MAGENTA = 35;
    public static final int CYAN = 36;
    public static final int WHITE = 37;
    public static final int DEFAULT_FG = 39;

    // ============================================
    // BACKGROUND COLORS
    // ============================================
    public static final int BG_BLACK = 40;
    public static final int BG_RED = 41;
    public static final int BG_GREEN = 42;
    public static final int BG_YELLOW = 43;
    public static final int BG_BLUE = 44;
    public static final int BG_MAGENTA = 45;
    public static final int BG_CYAN = 46;
    public static final int BG_WHITE = 47;
    public static final int BG_DEFAULT = 49;

    // ============================================
    // BRIGHT/HIGH-INTENSITY COLORS
    // ============================================
    public static final int BRIGHT_BLACK = 90;
    public static final int BRIGHT_RED = 91;
    public static final int BRIGHT_GREEN = 92;
    public static final int BRIGHT_YELLOW = 93;
    public static final int BRIGHT_BLUE = 94;
    public static final int BRIGHT_MAGENTA = 95;
    public static final int BRIGHT_CYAN = 96;
    public static final int BRIGHT_WHITE = 97;

    // ============================================
    // BRIGHT BACKGROUND COLORS
    // ============================================
    public static final int BG_BRIGHT_BLACK = 100;
    public static final int BG_BRIGHT_RED = 101;
    public static final int BG_BRIGHT_GREEN = 102;
    public static final int BG_BRIGHT_YELLOW = 103;
    public static final int BG_BRIGHT_BLUE = 104;
    public static final int BG_BRIGHT_MAGENTA = 105;
    public static final int BG_BRIGHT_CYAN = 106;
    public static final int BG_BRIGHT_WHITE = 107;

    // ============================================
    // TEXT STYLES
    // ============================================
    public static final int BOLD = 1;
    public static final int DIM = 2;
    public static final int ITALIC = 3;
    public static final int UNDERLINE = 4;
    public static final int BLINK = 5;
    public static final int INVERSE = 7;
    public static final int HIDDEN = 8;
    public static final int STRIKETHROUGH = 9;

    // ============================================
    // STATIC ERASE SEQUENCES
    // ============================================
    public static String eraseFCursorTEScreen = b(ER_SCREEN, END);
    public static String eraseFCursorTBScreen = b(ER_SCREEN, BEGIN);
    public static String eraseScreen = b(ER_SCREEN, ALL);
    public static String eraseSavedLines = b(ER_SCREEN, SAVED);
    public static String eraseFCursorTELine = b(ER_LINE, END);
    public static String eraseFCursorTBLine = b(ER_LINE, BEGIN);
    public static String eraseLine = b(ER_LINE, ALL);

    // ============================================
    // STATIC FORMAT SEQUENCES
    // ============================================
    public static String resetAll = b(FORMAT, END);
    public static String bold = b(FORMAT, String.valueOf(BOLD));
    public static String dim = b(FORMAT, String.valueOf(DIM));
    public static String italic = b(FORMAT, String.valueOf(ITALIC));
    public static String underline = b(FORMAT, String.valueOf(UNDERLINE));
    public static String blink = b(FORMAT, String.valueOf(BLINK));
    public static String inverse = b(FORMAT, String.valueOf(INVERSE));
    public static String hidden = b(FORMAT, String.valueOf(HIDDEN));
    public static String strikethrough = b(FORMAT, String.valueOf(STRIKETHROUGH));

    // ============================================
    // STATIC RESET SEQUENCES
    // ============================================
    public static String resetBold = b(FORMAT, "22");
    public static String resetDim = b(FORMAT, "22");
    public static String resetItalic = b(FORMAT, "23");
    public static String resetUnderline = b(FORMAT, "24");
    public static String resetBlink = b(FORMAT, "25");
    public static String resetInverse = b(FORMAT, "27");
    public static String resetHidden = b(FORMAT, "28");
    public static String resetStrikethrough = b(FORMAT, "29");

    // ============================================
    // STATIC CURSOR MOVEMENT
    // ============================================
    public static String moveHome = b(MOV_ABS);
    public static String saveCursorDEC = bDEC(SAVE_DEC);
    public static String restoreCursorDEC = bDEC(RESTORES_DEC);
    public static String saveCursorSCO = b(SAVE_SCO);
    public static String restoreCursorSCO = b(RESTORES_SCO);

    // ============================================
    // DYNAMIC CURSOR MOVEMENT
    // ============================================

    /**
     * Move cursor to absolute position (line, column)
     * @param line line number (1-based)
     * @param column column number (1-based)
     */
    static String moveAbsolute(int line, int column) {
        return b(MOV_ABS, String.valueOf(line), SEPARATOR, String.valueOf(column));
    }

    /**
     * Move cursor up # lines
     * @param lines number of lines
     */
    static String moveUp(int lines) {
        return b(MOV_UP, String.valueOf(lines));
    }

    /**
     * Move cursor up 1 line
     */
    static String moveUp() {
        return moveUp(1);
    }

    /**
     * Move cursor down # lines
     * @param lines number of lines
     */
    static String moveDown(int lines) {
        return b(MOV_DOWN, String.valueOf(lines));
    }

    /**
     * Move cursor down 1 line
     */
    static String moveDown() {
        return moveDown(1);
    }

    /**
     * Move cursor right # columns
     * @param columns number of columns
     */
    static String moveRight(int columns) {
        return b(MOV_RIGHT, String.valueOf(columns));
    }

    /**
     * Move cursor right 1 column
     */
    static String moveRight() {
        return moveRight(1);
    }

    /**
     * Move cursor left # columns
     * @param columns number of columns
     */
    static String moveLeft(int columns) {
        return b(MOV_LEFT, String.valueOf(columns));
    }

    /**
     * Move cursor left 1 column
     */
    static String moveLeft() {
        return moveLeft(1);
    }

    /**
     * Move cursor to beginning of next line, # lines down
     * @param lines number of lines
     */
    static String moveNextBLines(int lines) {
        return b(MOV_NEXT_BEG_LINE, String.valueOf(lines));
    }

    /**
     * Move cursor to beginning of previous line, # lines up
     * @param lines number of lines
     */
    static String movePrevBLines(int lines) {
        return b(MOV_PREV_BEG_LINE, String.valueOf(lines));
    }

    /**
     * Move cursor to absolute column
     * @param column column number (1-based)
     */
    static String moveAbsoluteColumn(int column) {
        return b(MOV_ABS_COL, String.valueOf(column));
    }

    // ============================================
    // COLOR AND FORMAT METHODS
    // ============================================

    /**
     * Apply foreground color to text
     * @param text text to colorize
     * @param color color code (e.g., RED, GREEN, BLUE)
     */
    public static String color(String text, int color) {
        return b(FORMAT, String.valueOf(color)) + text + resetAll;
    }

    /**
     * Apply background color to text
     * @param text text to colorize
     * @param bgColor background color code (e.g., BG_RED, BG_GREEN)
     */
    public static String bgColor(String text, int bgColor) {
        return b(FORMAT, String.valueOf(bgColor)) + text + resetAll;
    }

    /**
     * Apply foreground and background colors to text
     * @param text text to colorize
     * @param fgColor foreground color code
     * @param bgColor background color code
     */
    public static String color(String text, int fgColor, int bgColor) {
        return b(FORMAT, String.valueOf(fgColor), SEPARATOR, String.valueOf(bgColor)) + text + resetAll;
    }

    /**
     * Apply style to text
     * @param text text to style
     * @param style style code (e.g., BOLD, UNDERLINE, ITALIC)
     */
    public static String style(String text, int style) {
        return b(FORMAT, String.valueOf(style)) + text + resetAll;
    }

    /**
     * Apply color and style to text
     * @param text text to format
     * @param color color code
     * @param style style code
     */
    public static String colorStyle(String text, int color, int style) {
        return b(FORMAT, String.valueOf(style), SEPARATOR, String.valueOf(color)) + text + resetAll;
    }

    /**
     * Apply foreground color, background color, and style to text
     * @param text text to format
     * @param fgColor foreground color code
     * @param bgColor background color code
     * @param style style code
     */
    public static String colorStyle(String text, int fgColor, int bgColor, int style) {
        return b(FORMAT, String.valueOf(style), SEPARATOR, String.valueOf(fgColor), SEPARATOR, String.valueOf(bgColor))
                + text + resetAll;
    }

    // ============================================
    // CORE BUILDER METHODS
    // ============================================

    /**
     * Build standard ANSI escape sequence
     * First argument is the flag character, rest are parameters
     * @param flags parameters and flag
     */
    static String b(String ...flags) {
        if (flags.length == 0) return "";

        String params = String.join("", Arrays.stream(flags)
                .skip(1)
                .toArray(String[]::new));

        return ESC + "[" + params + flags[0];
    }

    /**
     * Build DEC-specific ANSI escape sequence (without CSI bracket)
     * @param flags parameters and flag
     */
    static String bDEC(String ...flags) {
        if (flags.length == 0) return "";

        return ESC + flags[0];
    }

    /**
     * Build 256-color foreground escape sequence
     * @param colorId color id (0-255)
     */
    static String color256(int colorId) {
        return b(FORMAT, "38", SEPARATOR, "5", SEPARATOR, String.valueOf(colorId));
    }

    /**
     * Build 256-color background escape sequence
     * @param colorId color id (0-255)
     */
    static String bgColor256(int colorId) {
        return b(FORMAT, "48", SEPARATOR, "5", SEPARATOR, String.valueOf(colorId));
    }

    /**
     * Build RGB foreground escape sequence (Truecolor 24-bit)
     * @param r red component (0-255)
     * @param g green component (0-255)
     * @param b blue component (0-255)
     */
    static String colorRGB(int r, int g, int b) {
        return cmd.b(FORMAT, "38", SEPARATOR, "2", SEPARATOR, String.valueOf(r), SEPARATOR, String.valueOf(g), SEPARATOR, String.valueOf(b));
    }

    /**
     * Build RGB background escape sequence (Truecolor 24-bit)
     * @param r red component (0-255)
     * @param g green component (0-255)
     * @param b blue component (0-255)
     */
    static String bgColorRGB(int r, int g, int b) {
        return cmd.b(FORMAT, "48", SEPARATOR, "2", SEPARATOR, String.valueOf(r), SEPARATOR, String.valueOf(g), SEPARATOR, String.valueOf(b));
    }

    /**
     * Apply RGB foreground and background colors to text
     * @param text text to colorize
     * @param fgR foreground red
     * @param fgG foreground green
     * @param fgB foreground blue
     * @param bgR background red
     * @param bgG background green
     * @param bgB background blue
     */
    static String colorRGB(String text, int fgR, int fgG, int fgB, int bgR, int bgG, int bgB) {
        String sequence = cmd.b(FORMAT, "38", SEPARATOR, "2", SEPARATOR, String.valueOf(fgR), SEPARATOR, String.valueOf(fgG),
                SEPARATOR, String.valueOf(fgB), SEPARATOR, "48", SEPARATOR, "2", SEPARATOR, String.valueOf(bgR),
                SEPARATOR, String.valueOf(bgG), SEPARATOR, String.valueOf(bgB));
        return sequence + text + resetAll;
    }

    // ============================================
    // UTILITY METHODS
    // ============================================

    /**
     * Clear entire screen and move cursor home
     */
    static String clearAll() {
        return eraseScreen + moveHome;
    }

    /**
     * Format text with all features
     * @param text text to format
     * @param fgColor foreground color code
     * @param bgColor background color code
     * @param styles variable number of style codes
     */
    static String format(String text, int fgColor, int bgColor, int... styles) {
        StringBuilder sb = new StringBuilder();
        sb.append(FORMAT).append(String.valueOf(fgColor)).append(SEPARATOR).append(String.valueOf(bgColor));

        for (int style : styles) {
            sb.append(SEPARATOR).append(String.valueOf(style));
        }

        return b(FORMAT, sb.substring(1)) + text + resetAll;
    }
}