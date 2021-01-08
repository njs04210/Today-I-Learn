package after;

public class SecondPage {
    private Settings settings = Settings.getSettings();

    public void printSettings() {
        System.out.println("Second page : " + settings.getDarkMode() + " " + settings.getFontSize());
    }
}
