package utils.repository;

import utils.repository.specifications.SqlSpecification;

import java.sql.SQLException;

/**
 * The type Repository.
 *
 * @param <T> the type parameter
 */
public class RepositoryBase<T> implements Repository<T> {
    @Override
    public int add(SqlSpecification<T> specification) throws SQLException {
        return specification.getSpecification().executeUpdate();
    }

    @Override
    public int update(SqlSpecification<T> specification) throws SQLException {
        return specification.getSpecification().executeUpdate();
    }

    @Override
    public int remove(SqlSpecification<T> specification) throws SQLException {
        return specification.getSpecification().executeUpdate();
    }
}
