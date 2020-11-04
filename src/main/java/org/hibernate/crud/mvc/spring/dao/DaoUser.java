package org.hibernate.crud.mvc.spring.dao;

import org.hibernate.crud.mvc.spring.model.User;

import java.util.List;

public interface DaoUser {

    void createUser(User user);

    User readUser(long id);

    void updateUser(User user);

    void deleteUser(Integer id);

    List<User> listUsers();
}
