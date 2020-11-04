package org.hibernate.crud.mvc.spring.service;

import org.hibernate.crud.mvc.spring.model.User;

import java.util.List;

public interface UserService {

    void createNewUser(User user);

    User readUser(Integer id);

    void updateUser(User user);

    void deleteUser(Integer id);

    List<User> usersList();
}
