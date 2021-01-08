package after;

public class FirstPage {
    private Settings settings = Settings.getSettings();

    public void setAndPrintSettings() {
        settings.setDarkMode(true);
        settings.setFontSize(15);
        System.out.println("First page : " + settings.getDarkMode() + " " + settings.getFontSize());
    }
}
