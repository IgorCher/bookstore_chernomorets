package com.belhard.bookstore.connection.impl;

import com.belhard.bookstore.connection.ConnectionManager;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl implements Closeable, ConnectionManager {
    private final String url;
    private final String login;
    private final String password;
    private Connection connection;

    public ConnectionManagerImpl(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    @Override
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, login, password);
            return connection;
        } catch (SQLException e) {
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
