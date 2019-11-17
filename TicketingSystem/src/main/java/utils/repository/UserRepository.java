package utils.repository;

import model.User;
import utils.enums.UserType;
import utils.repository.specifications.CheckUserSpecification;
import utils.repository.specifications.LoginSpecification;
import utils.repository.specifications.RegisterSpecification;

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
            UserType type = UserType.valueOf(result.getString("type").trim());
            String username = result.getString("username").trim();
            return new User.UserBuilder(username).setType(type).setId(id).build();
        }
        return null;
    }

    @Override
    public User register(User user) throws SQLException {
        int insertedUsers = new RegisterSpecification(user).getSpecification().executeUpdate();
        return insertedUsers == 1 ? user : null;
    }

    @Override
    public User checkUser(User user) throws SQLException {
        ResultSet result = new CheckUserSpecification(user).getSpecification().executeQuery();
        if (result.next()) {
            int id = result.getInt("id");
            UserType type = UserType.valueOf(result.getString("type").trim());
            String username = result.getString("username").trim();
            return new User.UserBuilder(username).setType(type).setId(id).build();
        }
        return null;
    }
}
