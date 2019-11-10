package repository;

import java.util.Collection;

public interface IRepository<T> {

     /** Adds an entity to the repository.
            *
            * @param entity
     *            the entity to add
     */


    public void add(final T entity);

    /**
     * Returns all the entities contained in the repository.
     *
     * @return all the entities contained in the repository
     */
    public Collection<T> getAll();

    /**
     * Removes an entity from the repository.
     *
     * @param entity
     *            the entity to remove
     */
    public void remove(final T entity);

    /**
     * Updates an entity on the repository.
     *
     * @param entity
     *            the entity to update.
     */
    public void update(final T entity);
}
