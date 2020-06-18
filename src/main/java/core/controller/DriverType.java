package core.controller;

public enum DriverType {

    CHROME,
    FIREFOX;

    public static DriverType getType() {
        String browser = System.getProperty("BROWSER");
        System.out.println("Input browser is - "+browser);
        if(browser == null) {
            browser = "chrome";
        }
        return DriverType.valueOf(browser);
    }

}
