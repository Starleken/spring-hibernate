package by.Starleken.repositories;

import by.Starleken.entities.Tag;
import by.Starleken.repositories.interfaces.TagRepository;
import by.Starleken.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealizationTagRepository implements TagRepository {

    private EntityManagerUtils entityManagerUtils;

    @Autowired
    public RealizationTagRepository(EntityManagerUtils entityManagerUtils) {
        this.entityManagerUtils = entityManagerUtils;
    }

    @Override
    public List<Tag> findAll() {
        EntityManager em = entityManagerUtils.getEntityManager();

        List<Tag> tags = em.createNativeQuery("SELECT * FROM tags", Tag.class).getResultList();

        em.close();
        return tags;
    }

    @Override
    public Tag findById(Long id) {
        EntityManager em = entityManagerUtils.getEntityManager();

        Tag tag = em.find(Tag.class, id);

        em.close();
        return tag;
    }

    @Override
    public Tag create(Tag entity) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();

        em.close();

        return entity;
    }

    @Override
    public void save(List<Tag> tags) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        for (Tag tag : tags){
            em.persist(tag);
        }

        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void update(Tag entity) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        Tag tag = em.find(Tag.class, entity.getId());
        tag.setName(entity.getName());

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        Tag tag = em.find(Tag.class, id);
        em.remove(tag);

        em.getTransaction().commit();
        em.close();
    }
}
