package app.model;

import app.entities.User;

import java.sql.*;
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
//
//    @Override
//    public Optional<Integer> save(User user) {
//        String message = "User name must not be NULL!";
//
//        User someone = Objects.requireNonNull(user, message);
//        String sql = "INSERT INTO "
//                + "users (user_name, user_password) "
//                + "VALUES(?,?)";
//        return connection.flatMap(conn -> {
//            Optional<Integer> generatedId = Optional.empty();
//            System.out.println("TestTestTest");
//
//            try (PreparedStatement statement =
//                         conn.prepareStatement(
//                                 sql,
//                                 Statement.RETURN_GENERATED_KEYS)) {
//
//                statement.setString(1, someone.getName());
//                statement.setString(2, someone.getPassword());
//                System.out.println("TestTestTest");
//
//                int numberOfInsertedRows = statement.executeUpdate();
//
//                // Retrieve the auto-generated id
//                if (numberOfInsertedRows > 0) {
//                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
//                        if (resultSet.next()) {
//                            generatedId = Optional.of(resultSet.getInt(1));
//                        }
//                    }
//                }
//
//                LOGGER.log(
//                        Level.INFO,
//                        "{0} created successfully? {1}",
//                        new Object[]{someone,
//                                (numberOfInsertedRows > 0)});
//            } catch (SQLException ex) {
//                LOGGER.log(Level.SEVERE, null, ex);
//            }
//
//            return generatedId;
//        });
//    }
}
