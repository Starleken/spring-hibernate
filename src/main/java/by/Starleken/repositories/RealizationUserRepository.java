package by.Starleken.repositories;

import by.Starleken.entities.User;
import by.Starleken.repositories.interfaces.UserRepository;
import by.Starleken.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealizationUserRepository implements UserRepository {

    private EntityManagerUtils entityManagerUtils;

    @Autowired
    public RealizationUserRepository(EntityManagerUtils entityManagerUtils) {
        this.entityManagerUtils = entityManagerUtils;
    }

    @Override
    public List<User> findAll() {
        EntityManager em = entityManagerUtils.getEntityManager();

        List<User> users = em.createNativeQuery("SELECT * FROM users", User.class).getResultList();

        em.close();
        return users;
    }

    @Override
    public User findById(Long id) {
        EntityManager em = entityManagerUtils.getEntityManager();

        User user = em.find(User.class, id);

        em.close();
        return user;
    }

    @Override
    public User create(User entity) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();
        em.close();

        return entity;
    }

    @Override
    public void update(User entity) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, entity.getId());
        user.setUsername(entity.getUsername());
        user.setImageURL(entity.getImageURL());

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, id);
        em.remove(user);

        em.getTransaction().commit();
        em.close();
    }
}
