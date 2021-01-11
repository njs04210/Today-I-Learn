package Singleton.before;

public class FirstPage {
    private Settings settings = new Settings();

    public void setAndPrintSettings() {
        settings.setDarkMode(true);
        settings.setFontSize(15);

        System.out.println("First Page : " + settings.getDarkMode()
        + " " + settings.getFontSize());
    }
}
