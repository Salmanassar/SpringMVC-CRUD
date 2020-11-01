package org.hibernate.crud.mvc.spring.service;

import org.hibernate.crud.mvc.spring.dao.Dao;
import org.hibernate.crud.mvc.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Dao dao;

    @Autowired
    public void setDao(Dao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public void createNewUser(User user) {
        dao.create(user);
    }

    @Transactional
    @Override
    public User readUser(long id) {
        return (User) dao.read(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        dao.delete(id);
    }

    @Transactional
    @Override
    public List<User> usersList() {
        return dao.listAll();
    }

    private boolean checkUser(User user){
        return (user.getId()!=null
                &&user.getName()!=null
                &&user.getLastName()!=null
                &&user.getYear()!=null);

    }
}
