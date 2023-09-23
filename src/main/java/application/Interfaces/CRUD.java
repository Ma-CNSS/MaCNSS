package application.Interfaces;

import java.util.List;

public interface CRUD {
    Object get(Object object);
    List<Object> getAll(Object object);
    Boolean add(Object object);
    Boolean update(Object object);
    Boolean delete(Object object);
}
