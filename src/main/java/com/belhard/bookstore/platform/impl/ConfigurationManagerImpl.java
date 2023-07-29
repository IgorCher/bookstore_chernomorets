package com.belhard.bookstore.platform.impl;

import com.belhard.bookstore.platform.ConfigurationManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManagerImpl implements ConfigurationManager {
    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream in = ConfigurationManagerImpl.class.getClassLoader().getResourceAsStream("database.properties")){
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
