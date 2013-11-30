package co.leantechniques.cheeper;

import java.util.Collection;

public interface Repository<T> {
    void save(T object);

    Collection<T> getAll();
}
