package by.Starleken.repositories.impl;

import by.Starleken.entities.User;
import by.Starleken.repositories.UserRepository;
import by.Starleken.services.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private EntityManagerProvider entityManagerProvider;

    @Autowired
    public UserRepositoryImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public List<User> findAll() {
        EntityManager em = entityManagerProvider.getEntityManager();

        List<User> users = em.createNativeQuery("SELECT * FROM users", User.class).getResultList();

        em.close();
        return users;
    }

    @Override
    public User findById(Long id) {
        EntityManager em = entityManagerProvider.getEntityManager();

        User user = em.find(User.class, id);

        em.close();
        return user;
    }

    @Override
    public User create(User entity) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();
        em.close();

        return entity;
    }

    @Override
    public void update(User entity) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, entity.getId());
        user.setUsername(entity.getUsername());
        user.setImageURL(entity.getImageURL());

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, id);
        em.remove(user);

        em.getTransaction().commit();
        em.close();
    }
}
