package org.hibernate.crud.mvc.spring.dao;

import org.hibernate.crud.mvc.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DaoImpl implements Dao<User> {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public User read(long id) {
        return (User) entityManager.createQuery("from User where id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(long id) {
        User user = read(id);
        entityManager.remove(user);
    }

    @Override
    public List<User> listAll() {
        TypedQuery<User> query =
                entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
