package utils.repository;

import utils.repository.specifications.SqlSpecification;

import java.sql.SQLException;

public interface IRepository<T> {

    int add(SqlSpecification<T> specification) throws SQLException;

    int update(SqlSpecification<T> specification) throws SQLException;

    int remove(SqlSpecification<T> specification) throws SQLException;
}