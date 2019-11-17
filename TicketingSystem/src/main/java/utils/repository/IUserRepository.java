package utils.repository;

import model.User;

import java.sql.SQLException;

/**
 * The interface User repository.
 */
public interface IUserRepository extends IRepository<User> {
    /**
     * Login user.
     *
     * @param user the user
     * @return the user
     * @throws SQLException the sql exception
     */
    User login(User user) throws SQLException;

    /**
     * Register user.
     *
     * @param user the user
     * @return the user
     * @throws SQLException the sql exception
     */
    User register(User user) throws SQLException;

    /**
     * Check user.
     *
     * @param user the user
     * @return the user
     * @throws SQLException the sql exception
     */
    User checkUser(User user) throws  SQLException;
}
