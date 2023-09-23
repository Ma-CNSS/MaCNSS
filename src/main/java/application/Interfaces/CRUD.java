package application.Interfaces;

import java.util.List;

public interface CRUD<T> {
    T get(T object);
    List<T> getAll(T object);
    Boolean add(T obj);
    Boolean update(T object);
    Boolean delete(T object);
}
