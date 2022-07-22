package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public Properties initProperties(){
        properties=new Properties();
        try {
            FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configs/config.properties");
            properties.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }
}
