package main.utils.loading;

import java.io.*;
import java.util.Properties;

public class PropertyLoader {
    public Properties loadProperties(File file){
        Properties properties = new Properties();
        try(Reader in = new FileReader(file)){
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
