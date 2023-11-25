package by.Starleken.controllers;

import by.Starleken.entities.Project;
import by.Starleken.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller()
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService ProjectService) {
        this.projectService = ProjectService;
    }

    @GetMapping("/projects")
    public String getAll(Model model){
        model.addAttribute("projects", projectService.findAll());
        return "projects";
    }

    @GetMapping("/projects/{id}")
    public String getById(Model model, @PathVariable Long id){
        model.addAttribute("project", projectService.findById(id));
        return "project-view";
    }

    @GetMapping("/projects/create")
    public String getCreateProjectView(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "project-create";
    }

    @PostMapping("/projects/create")
    public String createProject(Project project){
        projectService.create(project);

        return "redirect:/projects";
    }
}
