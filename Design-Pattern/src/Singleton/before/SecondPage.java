package Singleton.before;

public class SecondPage {
    private Settings settings = new Settings();

    public void printSettings() {
        System.out.println("Second Page : " + settings.getDarkMode()
        + " " + settings.getFontSize());
    }
}
