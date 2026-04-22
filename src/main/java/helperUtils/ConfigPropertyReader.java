package helperUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPropertyReader {

    private static String runningEnvironment =
            System.getProperty("RunEnv", "AWS-UAT"); // default if not passed

    private static String defaultConfigFile =
            "./Config." + runningEnvironment + ".properties";

    /**
     * Reads property from given property file
     */
    public static String getProperty(String propFile, String property) {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(propFile)) {
            prop.load(input);
            System.out.println(
                "Reading property: " + property +
                " | file: " + propFile +
                " | value: " + prop.getProperty(property)
            );
            return prop.getProperty(property);
        } catch (Exception ex) {
            throw new RuntimeException(
                "Failed to read property: " + property +
                " from file: " + propFile, ex
            );
        }
    }

    /**
     * Reads property from default environment file
     */
    public static String getProperty(String property) {
        return getProperty(defaultConfigFile, property);
    }
}