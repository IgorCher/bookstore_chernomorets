package com.belhard.bookstore.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProperties {
    private static String url;
    private static String login;
    private static String password;

    public static String getUrl() {
        try (BufferedReader br = new BufferedReader(new FileReader("database.properties"))) {
            List<String> properties = new ArrayList<>();
            String s;
            while ((s = br.readLine()) != null) {
                properties.add(s);
            }
            url = properties.get(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static String getLogin() {
        try (BufferedReader br = new BufferedReader(new FileReader("database.properties"))) {
            List<String> properties = new ArrayList<>();
            String s;
            while ((s = br.readLine()) != null) {
                properties.add(s);
            }
            login = properties.get(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return login;
    }

    public void setUser(String user) {
        this.login = user;
    }

    public static String getPassword() {
        try (BufferedReader br = new BufferedReader(new FileReader("database.properties"))) {
            List<String> properties = new ArrayList<>();
            String s;
            while ((s = br.readLine()) != null) {
                properties.add(s);
            }
            password = properties.get(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
