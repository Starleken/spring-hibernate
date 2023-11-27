package by.Starleken.repositories.impl;

import by.Starleken.entities.Tag;
import by.Starleken.repositories.TagRepository;
import by.Starleken.services.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepository {

    private EntityManagerProvider entityManagerProvider;

    @Autowired
    public TagRepositoryImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public List<Tag> findAll() {
        EntityManager em = entityManagerProvider.getEntityManager();

        List<Tag> tags = em.createNativeQuery("SELECT * FROM tags", Tag.class).getResultList();

        em.close();
        return tags;
    }

    @Override
    public Tag findById(Long id) {
        EntityManager em = entityManagerProvider.getEntityManager();

        Tag tag = em.find(Tag.class, id);

        em.close();
        return tag;
    }

    @Override
    public Tag create(Tag entity) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();

        em.close();

        return entity;
    }

    @Override
    public void save(List<Tag> tags) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        for (Tag tag : tags){
            em.persist(tag);
        }

        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void update(Tag entity) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        Tag tag = em.find(Tag.class, entity.getId());
        tag.setName(entity.getName());

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        Tag tag = em.find(Tag.class, id);
        em.remove(tag);

        em.getTransaction().commit();
        em.close();
    }
}
