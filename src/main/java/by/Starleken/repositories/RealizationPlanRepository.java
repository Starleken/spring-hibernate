package by.Starleken.repositories;

import by.Starleken.entities.Plan;
import by.Starleken.repositories.interfaces.PlanRepository;
import by.Starleken.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class RealizationPlanRepository implements PlanRepository {

    private EntityManagerUtils entityManagerUtils;

    @Autowired
    public RealizationPlanRepository(EntityManagerUtils entityManagerUtils) {
        this.entityManagerUtils = entityManagerUtils;
    }

    @Override
    public List<Plan> findAll() {
        EntityManager em = entityManagerUtils.getEntityManager();

        List<Plan> plans =em.createNativeQuery("SELECT * FROM plans", Plan.class).getResultList();

        em.close();
        return plans;
    }

    @Override
    public Plan findById(Long id) {
        EntityManager em = entityManagerUtils.getEntityManager();

        Plan plan = em.find(Plan.class, id);

        em.close();
        return plan;
    }

    @Override
    public Plan create(Plan entity) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();
        em.close();

        return entity;
    }

    @Override
    public void update(Plan entity) {
        EntityManager em = entityManagerUtils.getEntityManager();
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
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        Plan plan = em.find(Plan.class, id);
        em.remove(plan);

        em.getTransaction().commit();
    }
}
