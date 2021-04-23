package optional.dao;

import java.util.List;

/**
 * compulsory.dao interface
 * @param <T>
 */
interface DAO<T> {
    List<T> findById(int id);

    List<T> findByName(String name);

    List<T> getAll();

    void insert(T t);

    void delete(T t);


}