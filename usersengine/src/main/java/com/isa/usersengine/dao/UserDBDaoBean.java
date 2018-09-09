package com.isa.usersengine.dao;

import com.isa.usersengine.domain.Stats;
import com.isa.usersengine.domain.Status;
import com.isa.usersengine.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Stateless
public class UserDBDaoBean implements UserDBDao {


    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");

    @Override
    public User getUserFromDataBaseById(int id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class , id);
        return user;

    }

    @Override
    public void putUserToDataBase(User user) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Stats stats = new Stats();
            user.setStats(stats);
            stats.setUser(user);

            entityManager.persist(user);

            transaction.commit();
        }catch(Exception ex){
            if(transaction!=null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally {
            entityManager.close();
        }

    }

    @Override
    public void removeUserFromDataBaseById(int id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        User user = entityManager.find(User.class, id);
        transaction.begin();

        user.setStatus(Status.D);
        entityManager.merge(user);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<User> getUsersFromDataBase() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> users = entityManager.createQuery("from User").getResultList();
        return users;
    }

    @Override
    public void updateUserInDataBase(int id, User user) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        User userFromDB = entityManager.find(User.class, id);
        transaction.begin();

        userFromDB.setName(user.getName());
        userFromDB.setSurname(user.getSurname());
        userFromDB.setLogin(user.getLogin());
        userFromDB.setPassword(user.getPassword());
        userFromDB.setAge(user.getAge());
        userFromDB.setStats(user.getStats());

        entityManager.merge(userFromDB);
        transaction.commit();

    }
}
