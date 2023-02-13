package de.herrives.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ChadGPTConfig {


    public Properties readProperties(String filePath){
        Properties chadGPTProperties = new Properties();

        try {
            chadGPTProperties.load(getClass().getClassLoader().getResourceAsStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return chadGPTProperties;
    }

}
