package org.hibernate.crud.mvc.spring.service;

import org.hibernate.crud.mvc.spring.model.User;

import java.util.List;

public interface UserService {

    void createNewUser(User user);

    User readUser(long id);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> usersList();
}
