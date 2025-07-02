package tests;

public class ConfigReader {

    public static String getBrowser() {
        return System.getProperty("browser", "chrome").toLowerCase();
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(System.getProperty("headless", "true"));
    }

//    public static String getEnvironment() {
//        return System.getProperty("env", "staging").toLowerCase();
//    }
}
