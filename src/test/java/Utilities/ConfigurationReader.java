package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configFile;
static {
    String path = "configuration.properties";
    try {
        FileInputStream input = new FileInputStream(path);
        configFile = new Properties();
        configFile.load(input);
        input.close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
    public static String getProperty(String keyName){
        return configFile.getProperty(keyName);
    }
}
