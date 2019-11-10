package utils.repository;

import utils.repository.specifications.SqlSpecification;

import java.sql.SQLException;

public class Repository<T> implements IRepository<T> {
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
