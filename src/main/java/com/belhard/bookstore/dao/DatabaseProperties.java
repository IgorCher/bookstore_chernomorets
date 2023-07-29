package com.belhard.bookstore.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseProperties {
    private static Properties properties;

       static {
           properties = new Properties();
           try (InputStream in = DatabaseProperties.class.getClassLoader().getResourceAsStream("database.properties")){
               properties.load(in);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }

    public static String getUrl (){
        return properties.getProperty("db.url");
    }
    public static String getLogin (){
        return properties.getProperty("db.login");
    }
    public static String getPassword (){
        return properties.getProperty("db.password");
    }
}
