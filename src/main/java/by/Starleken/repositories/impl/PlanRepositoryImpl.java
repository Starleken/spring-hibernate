package by.Starleken.repositories.impl;

import by.Starleken.entities.Plan;
import by.Starleken.repositories.PlanRepository;
import by.Starleken.services.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanRepositoryImpl implements PlanRepository {

    private EntityManagerProvider entityManagerProvider;

    @Autowired
    public PlanRepositoryImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public List<Plan> findAll() {
        EntityManager em = entityManagerProvider.getEntityManager();

        List<Plan> plans =em.createNativeQuery("SELECT * FROM plans", Plan.class).getResultList();

        em.close();
        return plans;
    }

    @Override
    public Plan findById(Long id) {
        EntityManager em = entityManagerProvider.getEntityManager();

        Plan plan = em.find(Plan.class, id);

        em.close();
        return plan;
    }

    @Override
    public Plan create(Plan entity) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();
        em.close();

        return entity;
    }

    @Override
    public void update(Plan entity) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        Plan plan = em.find(Plan.class, entity.getId());
        plan.setName(entity.getName());
        plan.setDescription(entity.getDescription());
        plan.setDate(entity.getDate());

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerProvider.getEntityManager();
        em.getTransaction().begin();

        Plan plan = em.find(Plan.class, id);
        em.remove(plan);

        em.getTransaction().commit();
    }
}
