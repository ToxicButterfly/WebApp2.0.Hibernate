package app.model;

import app.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser{

    private static final Logger LOGGER =
            Logger.getLogger(DaoUser.class.getName());

    private final Connection connection;

    public DaoUser() throws ClassNotFoundException {
        this.connection = JdbcConnection.getConnection();
    }

    public void save(User user) {
        String message = "User name must not be NULL!";

        User someone = Objects.requireNonNull(user, message);
        String sql = "INSERT INTO "
                + "users (user_name, user_password) "
                + "VALUES(?,?)";

            try (PreparedStatement statement =
                         this.connection.prepareStatement(
                                 sql,
                                 Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, someone.getName());
                statement.setString(2, someone.getPassword());
                System.out.println("TestTestTest");

                int numberOfInsertedRows = statement.executeUpdate();


                LOGGER.log(
                        Level.INFO,
                        "{0} created successfully? {1}",
                        new Object[]{someone,
                                (numberOfInsertedRows > 0)});
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
    }
    public List<User> getAll() throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT user_name, user_password FROM users";
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            String name = resultSet.getString("user_name");
            String pass = resultSet.getString("user_password");
            User user = new User(name, pass);
            list.add(user);
        }
        return list;
    };
}
