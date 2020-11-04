package org.hibernate.crud.mvc.spring.service;

import org.hibernate.crud.mvc.spring.dao.DaoUser;
import org.hibernate.crud.mvc.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private DaoUser daoUser;

    @Autowired
    public void setDaoUser(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    @Transactional
    @Override
    public void createNewUser(User user) {
        daoUser.createUser(user);
    }

    @Transactional
    @Override
    public User readUser(Integer id) {
        return (User) daoUser.readUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        daoUser.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        daoUser.deleteUser(id);
    }

    @Transactional
    @Override
    public List<User> usersList() {
        return daoUser.listUsers();
    }

    private boolean checkUser(User user){
        return (user.getId()!=null
                &&user.getName()!=null
                &&user.getLastName()!=null
                &&user.getYear()!=null);

    }
}
