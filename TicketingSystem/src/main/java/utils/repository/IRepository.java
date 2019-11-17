package utils.repository;

import utils.repository.specifications.SqlSpecification;

import java.sql.SQLException;

/**
 * The interface Repository.
 *
 * @param <T> the type parameter
 */
public interface IRepository<T> {

    /**
     * Add command.
     *
     * @param specification the specification
     * @return the number of added entities
     * @throws SQLException the sql exception
     */
    int add(SqlSpecification<T> specification) throws SQLException;

    /**
     * Update command.
     *
     * @param specification the specification
     * @return the number of updated entities
     * @throws SQLException the sql exception
     */
    int update(SqlSpecification<T> specification) throws SQLException;

    /**
     * Remove command.
     *
     * @param specification the specification
     * @return the number of removed entities
     * @throws SQLException the sql exception
     */
    int remove(SqlSpecification<T> specification) throws SQLException;
}