package utils.repository;

import model.User;

import java.sql.SQLException;

public interface IUserRepository extends IRepository<User> {
    User login(User user) throws SQLException;
    User register(User user) throws SQLException;
}
