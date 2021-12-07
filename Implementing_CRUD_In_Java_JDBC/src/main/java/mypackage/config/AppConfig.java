package mypackage.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    public static Properties getconfig(){
        Properties properties = new Properties();
        try{
            InputStream is = AppConfig.class.getResourceAsStream("/config.properties");
            properties.load(is);
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return properties;
    }
}
