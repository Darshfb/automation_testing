package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    // load the properties file from the folder
    public static Properties userData = LoadProperties(System.getProperty("user.dir")+ "\\src\\main\\java\\properties\\UserData.properties");

    private static Properties LoadProperties(String path) {
        Properties properties = new Properties();
        // stream for reading the file
        try {
            FileInputStream stream = new FileInputStream(path);
            properties.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred : " + e.getMessage());
        }  catch (IOException e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
        return properties;
    }

}
