package repository.specifications;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The type Sql specification.
 *
 * @param <T> the type parameter
 */
public abstract class SqlSpecification<T> {

    /**
     * The Entity.
     */
    protected T entity;

    /**
     * Instantiates a new Sql specification.
     *
     * @param entity the entity
     */
    public SqlSpecification(T entity) {
        this.entity = entity;
    }

    /**
     * Gets specification.
     *
     * @return the specification
     * @throws SQLException the sql exception
     */
    public abstract PreparedStatement getSpecification() throws SQLException;
}
