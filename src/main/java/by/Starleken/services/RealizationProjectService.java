package by.Starleken.services;

import by.Starleken.entities.Project;
import by.Starleken.interfaces.CRUD;
import by.Starleken.repositories.RealizationProjectRepository;
import by.Starleken.repositories.interfaces.ProjectRepository;
import by.Starleken.services.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealizationProjectService implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public RealizationProjectService(ProjectRepository ProjectRepository) {
        this.projectRepository = ProjectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id){
        return projectRepository.findById(id);
    }

    public Project create(Project project){
        return projectRepository.create(project);
    }

    @Override
    public void update(Project entity) {
        projectRepository.update(entity);
    }

    @Override
    public void delete(Long id) {
        projectRepository.delete(id);
    }
}
