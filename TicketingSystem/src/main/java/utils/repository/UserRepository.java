package utils.repository;

import model.User;
import utils.repository.specifications.LoginSpecification;
import utils.repository.specifications.RegisterSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository extends Repository<User> implements IUserRepository {

    @Override
    public User login(User user) throws SQLException {
        ResultSet result = new LoginSpecification(user).getSpecification().executeQuery();
        if (result.next()) {
            String type = result.getString("type");
            String username = result.getString("username");
            return new User.UserBuilder(username).setType(type).build();
        }
        return null;
    }

    @Override
    public User register(User user) throws SQLException {
        int insertedUsers = new RegisterSpecification(user).getSpecification().executeUpdate();
        return insertedUsers == 1 ? user : null;
    }
}
