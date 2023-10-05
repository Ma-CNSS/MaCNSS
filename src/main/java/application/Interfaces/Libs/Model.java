package application.Interfaces.Libs;

import java.util.List;
/**
 * The `Model2` interface defines the standard CRUD (Create, Read, Update, Delete) operations
 * that can be performed on a database table.
 *
 * @param <T> The type associated with this interface.
 */
public interface Model<T> {

    /**
     * Associates a model object with this ORM instance.
     *
     * @param object The model object to associate.
     * @return An instance of the model with the object associated.
     */
    Model<T> setObject(T object);
    /**
     * Starts a database transaction.
     *
     * @return An instance of the model with a transaction in progress.
     */
    Model<T> beginTransaction();

    /**
     * Commits and validates the ongoing transaction.
     *
     * @return An instance of the model after successfully committing the transaction.
     */
    Model<T> commitTransaction();

    /**
     * Rolls back and cancels the ongoing transaction.
     *
     * @return An instance of the model after canceling the transaction.
     */
    Model<T> rollbackTransaction();

    /**
     * Retrieves all records from the associated database table.
     *
     * @return A list of maps, where each map represents a row of data with column names as keys.
     */
    List<T> getAll();

    /**
     * Retrieves a specific record from the database table.
     *
     * @return A model representing the specific record.
     */
    T get();

    /**
     * Saves the associated model object to the database.
     *
     * @return The saved model.
     */
    T save();

    /**
     * Gets an instance of the model class associated with this ORM.
     *
     * @return An instance of the model class.
     */
    Model<T> getEntityClass();

    /**
     * Specifies a "WHERE" condition for queries.
     *
     * @param key   The name of the column.
     * @param value The value to compare.
     * @return An instance of the model with the "WHERE" condition added.
     */
    Model<T> where(String key, Object value);

    /**
     * Specifies a "WHERE" condition with a custom operator for queries.
     *
     * @param key      The name of the column.
     * @param operator The custom comparison operator (e.g., "=", "<").
     * @param value    The value to compare.
     * @return An instance of the model with the "WHERE" condition added.
     */
    Model<T> where(String key, String operator, Object value);

    /**
     * Specifies an "AND" condition for queries.
     *
     * @param key   The name of the column.
     * @param value The value to compare.
     * @return An instance of the model with the "AND" condition added.
     */
    Model<T> and(String key, Object value);

    /**
     * Specifies an "AND" condition with a custom operator for queries.
     *
     * @param key      The name of the column.
     * @param operator The custom comparison operator (e.g., "=", "<").
     * @param value    The value to compare.
     * @return An instance of the model with the "AND" condition added.
     */
    Model<T> and(String key, String operator, Object value);

    /**
     * Specifies an "OR" condition for queries.
     *
     * @param key   The name of the column.
     * @param value The value to compare.
     * @return An instance of the model with the "OR" condition added.
     */
    Model<T> or(String key, Object value);

    /**
     * Specifies an "OR" condition with a custom operator for queries.
     *
     * @param key      The name of the column.
     * @param operator The custom comparison operator (e.g., "=", "<").
     * @param value    The value to compare.
     * @return An instance of the model with the "OR" condition added.
     */
    Model<T> or(String key, String operator, Object value);

    /**
     * Specifies a "LIKE" condition for queries.
     *
     * @param key   The name of the column.
     * @param value The value to search for.
     * @return An instance of the model with the "LIKE" condition added.
     */
    Model<T> like(String key, Object value);

    /**
     * Limits the number of results returned by the query.
     *
     * @param limit The maximum number of records to return.
     * @return An instance of the model with the limit added.
     */
    Model<T> limit(int limit);

    /**
     * Sets an offset for query results.
     *
     * @param offset The number of records to skip before starting to return results.
     * @return An instance of the model with the offset added.
     */
    Model<T> offset(int offset);

    /**
     * Specifies the sorting order of query results.
     *
     * @param key       The column name for sorting.
     * @param direction The sorting direction (ascending or descending).
     * @return An instance of the model with the specified sorting order.
     */
    Model<T> orderBy(String key, String direction);

    /**
     * Executes the query and returns a list of results.
     *
     * @return A list of models corresponding to the query.
     */
    List<T> find();

    /**
     * Executes the query and returns a single result.
     *
     * @return A model corresponding to the query.
     */
    T findOne();

    /**
     * Updates records in the associated database table with the provided data based on specified primary key values.
     *
     * @return True if the update operation is successful; otherwise, false.
     */
    boolean update();

    /**
     * Deletes records from the associated database table based on specified primary key values.
     *
     * @param ids An array of primary key values used to identify the records to be deleted.
     * @return True if the delete operation is successful; otherwise, false.
     */
    boolean delete();

    /**
     * Deletes records from the associated database table based on specified primary key values.
     *
     * @return True if the delete operation is successful; otherwise, false.
     */
    boolean softDelete();
}