package com.belhard.bookstore.data.connection.impl;

import com.belhard.bookstore.data.connection.ConnectionManager;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl implements Closeable, ConnectionManager {
    private final String url;
    private final String login;
    private final String password;
    private final String driver;
    private Connection connection;

    public ConnectionManagerImpl(String url, String login, String password, String driver) {
        this.url = url;
        this.login = login;
        this.password = password;
        this.driver = driver;
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, password);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
