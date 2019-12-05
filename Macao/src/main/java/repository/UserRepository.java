package repository;

import model.User;
import repository.specifications.LoginSpecification;
import repository.specifications.RegisterSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type User repository.
 */
public class UserRepository extends Repository<User> implements IUserRepository {

    @Override
    public User login(User user) throws SQLException {
        ResultSet result = new LoginSpecification(user).getSpecification().executeQuery();
        if (result.next()) {
            int id = result.getInt("id");
            String username = result.getString("username").trim();
            return new User.UserBuilder(username).setId(id).build();
        }
        return null;
    }

    @Override
    public User register(User user) throws SQLException {
        int insertedUsers = new RegisterSpecification(user).getSpecification().executeUpdate();
        return insertedUsers == 1 ? user : null;
    }
}
