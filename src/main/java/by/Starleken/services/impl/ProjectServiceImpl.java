package by.Starleken.services.impl;

import by.Starleken.entities.Project;
import by.Starleken.repositories.ProjectRepository;
import by.Starleken.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository ProjectRepository) {
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
