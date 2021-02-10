package com.bakery.management.service;

import java.util.Set;

/***
 * Provides a custom repository interface for {@see Address}.
 * @param <T> type of a domain model class
 * @since 1.0
 * @author Moustapha Star
 */
public interface AddressManager<T> {

    /***
     * Persists entity to database.
     * @param entity entity to persist
     * @return persisted entity
     */
    T persist(T entity);

    /***
     * Removes entity from database.
     * @param entity entity to remove
     * @return true if entity is removed
     */
    boolean remove(T entity);

    /***
     * Updates entity in database.
     * @param entity entity to update
     * @return updated entity
     */
    T update(T entity);

    /***
     * Fetches entity from database.
     * @param entity entity to find
     * @return found entity
     */
    T find(T entity);

    /***
     * Fetches entity from database using a predicate.
     * @param predicate predicate to apply
     * @return found entity
     */
    T findByPredicate(String predicate);

    /***
     * Fetches entity from database using a predicate.
     * @param predicate predicate to apply
     * @return found entity set
     */
    Set<T> findListByPredicate(String predicate);
}
