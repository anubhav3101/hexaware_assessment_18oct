package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertyutil {

    public static Properties getPropertyString() {
        Properties props = new Properties();
        try (InputStream input = DBPropertyutil.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return null;
            }

            // Load the properties file
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props;
    }
}
