package by.Starleken.repositories;

import by.Starleken.entities.Project;
import by.Starleken.repositories.interfaces.ProjectRepository;
import by.Starleken.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealizationProjectRepository implements ProjectRepository {

    private EntityManagerUtils entityManagerUtils;

    @Autowired
    public RealizationProjectRepository(EntityManagerUtils entityManagerUtils) {
        this.entityManagerUtils = entityManagerUtils;
    }

    public List<Project> findAll(){
        EntityManager em = entityManagerUtils.getEntityManager();

        List<Project> projects = em.createNativeQuery("Select * from projects", Project.class).getResultList();

        em.close();

        return projects;
    }

    public Project findById(Long id){
        EntityManager em = entityManagerUtils.getEntityManager();

        Project project = em.find(Project.class, id);

        em.close();

        return project;
    }

    @Override
    public Project create(Project entity) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        em.persist(entity);

        em.getTransaction().commit();
        em.close();

        return entity;
    }

    @Override
    public void update(Project entity) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        Project project = em.find(Project.class, entity.getId());
        project.setName(entity.getName());
        project.setDescription(entity.getDescription());
        project.setURL(entity.getURL());

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerUtils.getEntityManager();
        em.getTransaction().begin();

        Project project = em.find(Project.class, id);
        em.remove(project);

        em.getTransaction().commit();
        em.close();
    }
}
