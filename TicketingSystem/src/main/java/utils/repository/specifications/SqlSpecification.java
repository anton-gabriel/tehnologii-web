package utils.repository.specifications;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class SqlSpecification<T> {

    protected T entity;

    public SqlSpecification(T entity) {
        this.entity = entity;
    }

    public abstract PreparedStatement getSpecification() throws SQLException;
}
