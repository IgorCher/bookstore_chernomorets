package com.belhard.bookstore.dao;

import com.belhard.bookstore.dao.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private final String URL = DatabaseProperties.getUrl();
    private static final String LOGIN = DatabaseProperties.getLogin();
    private static final String PASSWORD = DatabaseProperties.getPassword();

    private static final String FIND_ALL = "SELECT * FROM books";
    private static final String FIND_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String FIND_BY_AUTHOR = "SELECT * FROM books WHERE author = ?";
    private static final String FIND_BY_ISBN = "SELECT * FROM books WHERE isbn = ?";
    private static final String CREATE = "INSERT INTO books (author, name, year, pages, isbn) Values (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE books SET author = ?, name = ?, year = ?, pages = ?, isbn = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM books WHERE id = ?";



    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                books.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_AUTHOR);
            preparedStatement.setString(1, author);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public Book find(long id) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Book findByIsbn(String isbn) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ISBN);
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Book create(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, book.getAuthor());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3, book.getYear());
            preparedStatement.setInt(4, book.getPages());
            preparedStatement.setString(5, book.getIsbn());

            preparedStatement.executeUpdate();


            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                long id = generatedKeys.getLong("id");
                return find(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setString(1, book.getAuthor());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3, book.getYear());
            preparedStatement.setInt(4, book.getPages());
            preparedStatement.setString(5, book.getIsbn());
            preparedStatement.setLong(6, book.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public boolean delete(long id) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setLong(1, id);
            int rows = preparedStatement.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long countAll() {
        return findAll().size();
    }

    public static Book mapRow(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("author"));
        book.setYear(resultSet.getString("year"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setPages(resultSet.getInt("pages"));
        return book;
    }
}
