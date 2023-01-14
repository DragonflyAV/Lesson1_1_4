package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(40) NOT NULL, lastName VARCHAR(40) NOT NULL, age INT NOT NULL)";
    private final String DROP_TABLE = "DROP TABLE IF EXISTS users";
    private final String SAVE_USER = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
    private final String REMOVE_USER = "DELETE FROM users WHERE id = ?";
    private final String GET_ALL = "SELECT * FROM users";
    private final String CLEAN_TABLE = "TRUNCATE users";


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.getConnection()) {
            connection.createStatement().execute(CREATE_TABLE);
        } catch (SQLException e) {
            System.err.println("SQLException");
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.getConnection()) {
            connection.createStatement().execute(DROP_TABLE);
        } catch (SQLException e) {
            System.err.println("SQLException");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQLException");
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_USER);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQLException");
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("SQLException");
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection()) {
            connection.createStatement().execute(CLEAN_TABLE);
        } catch (SQLException e) {
            System.err.println("SQLException");
        }
    }
}
