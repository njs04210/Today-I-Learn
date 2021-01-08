package after;

public class Settings {
    private boolean darkMode = false;
    private int fontSize = 13;
    private static Settings settings = null;

    public static Settings getSettings() {
        if (settings == null)
            settings = new Settings();
        return settings;
    }

    public boolean getDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
