package org.hibernate.crud.mvc.spring.dao;

import java.util.List;

public interface Dao<T> {
    void create(T t);

    T read(long id);

    void update(T t);

    void delete(long id);

    List<T> listAll();
}
