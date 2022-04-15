package app.model;

import java.util.List;
import java.util.Optional;

public interface Dao<T, ID> {
    void save(T t);
    Optional<T> find(int id);
    List<T> findAll();
    void delete(int id);
}
