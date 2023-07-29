package com.belhard.bookstore.dao;

import com.belhard.bookstore.dao.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static final String URL = DatabaseProperties.getUrl();
    private static final String LOGIN = DatabaseProperties.getLogin();
    private static final String PASSWORD = DatabaseProperties.getPassword();

    private static final String FIND_ALL = "SELECT b.id, b.author, b.title, b.year, b.price, b.pages, b.isbn, c.cover_type FROM books b JOIN cover_types c ON b.cover_type_id = c.id";
    private static final String FIND_BY_ID = "SELECT b.id, b.author, b.title, b.year, b.price, b.pages, b.isbn, c.cover_type FROM books b JOIN cover_types c ON b.cover_type_id = c.id WHERE b.id = ?";
    private static final String FIND_BY_AUTHOR = "SELECT b.id, b.author, b.title, b.year, b.price, b.pages, b.isbn, c.cover_type FROM books b JOIN cover_types c ON b.cover_type_id = c.id WHERE b.author = ?";
    private static final String FIND_BY_ISBN = "SELECT b.id, b.author, b.title, b.year, b.price, b.pages, b.isbn, c.cover_type FROM books b JOIN cover_types c ON b.cover_type_id = c.id WHERE b.isbn = ?";
    private static final String CREATE = "INSERT INTO books (author, title, year, price, pages, isbn, cover_type_id) Values (?, ?, ?, ?, ?, ?, (SELECT id FROM cover_types WHERE cover_type = ?))";
    private static final String UPDATE = "UPDATE books SET author = ?, title = ?, year = ?, price = ?, pages = ?, isbn = ?, cover_type_id = (SELECT id FROM cover_types WHERE cover_type = ?) WHERE id = ?";
    private static final String COUNT = "SELECT COUNT(b.id) FROM books b";
    private static final String DELETE = "DELETE FROM books WHERE id = ?";
    private static final Logger log = LogManager.getLogger(BookDaoImpl.class);



    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            log.info("Connected to database");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                books.add(mapRow(resultSet));
                log.debug("SQL query");
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
            log.info("Connected to database");
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_AUTHOR);
            preparedStatement.setString(1, author);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(mapRow(resultSet));
                log.debug("SQL query");
            }
        } catch (SQLException e) {
            log.error("Connection failed");
            throw new RuntimeException(e);
        }
        return books;
    }

    public Book find(long id) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            log.info("Connected to database");
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            log.debug("SQL query");
            if (resultSet.next()) {
                return mapRow(resultSet);
            }
        } catch (SQLException e) {
            log.error("Connection failed");
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Book findByIsbn(String isbn) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            log.info("Connected to database");
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ISBN);
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();
            log.debug("SQL query");
            if (resultSet.next()) {
                return mapRow(resultSet);
            }
        } catch (SQLException e) {
            log.error("Connection failed");
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Book create(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            log.info("Connected to database");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, book.getAuthor());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getYear());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setInt(5, book.getPages());
            preparedStatement.setString(6, book.getIsbn());
            preparedStatement.setString(7, book.getCover().toString());

            preparedStatement.executeUpdate();
            log.debug("SQL query");

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                long id = generatedKeys.getLong("id");
                return find(id);
            }
        } catch (SQLException e) {
            log.error("Connection failed");
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            log.info("Connected to database");
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setString(1, book.getAuthor());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getYear());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setInt(5, book.getPages());
            preparedStatement.setString(6, book.getIsbn());
            preparedStatement.setString(7, book.getCover().toString());
            preparedStatement.setLong(8, book.getId());

            preparedStatement.executeUpdate();
            log.debug("SQL query");

        } catch (SQLException e) {
            log.error("Connection failed");
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public boolean delete(long id) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            log.info("Connected to database");
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setLong(1, id);
            int rows = preparedStatement.executeUpdate();
            log.debug("SQL query");
            return rows == 1;
        } catch (SQLException e) {
            log.error("Connection failed");
            throw new RuntimeException(e);
        }
    }

    @Override
    public long countAll() {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            log.info("Connected to database");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(COUNT);
            log.debug("SQL query");
            if (resultSet.next()) {
                return resultSet.getLong("count");
            }
        } catch (SQLException e) {
            log.error("Connection failed");
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static Book mapRow(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setYear(resultSet.getString("year"));
        book.setPrice(resultSet.getDouble("price"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setPages(resultSet.getInt("pages"));
        String coverRaw = resultSet.getString("cover_type");
        book.setCover(Book.Cover.valueOf(coverRaw));
        return book;
    }
}
