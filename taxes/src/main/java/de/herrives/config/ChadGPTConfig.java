package de.herrives.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ChadGPTConfig {


    public Properties readProperties(){
        Properties chadGPTProperties = new Properties();
        chadGPTProperties.put("endPoint", "https://api.openai.com/v1/completions");
        chadGPTProperties.put("apiKey", "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");
        chadGPTProperties.put("promptPattern", "we have %s. If it is kind of food, or kind of book, or kind of medical product, answer \\\"yes\\\". otherwise, answer \\\"no\\\"");

        return chadGPTProperties;
    }

}
