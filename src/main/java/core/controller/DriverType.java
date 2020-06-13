package core.controller;

public enum DriverType {

    CHROME,
    FIREFOX,
    IE,
    REMOTE;

    public static DriverType getType() {
        String browser = System.getProperty("browser", "CHROME");
        return DriverType.valueOf(browser);
    }

}
