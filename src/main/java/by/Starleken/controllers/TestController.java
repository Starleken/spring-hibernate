package by.Starleken.controllers;

import by.Starleken.entities.Comment;
import by.Starleken.entities.Project;
import by.Starleken.entities.User;
import by.Starleken.services.interfaces.CommentService;
import by.Starleken.services.interfaces.ProjectService;
import by.Starleken.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class TestController {

    private ProjectService projectService;
    private CommentService commentService;
    private UserService userService;

    @Autowired
    public TestController(ProjectService projectService, CommentService commentService, UserService userService) {
        this.projectService = projectService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/test")
    public String createData(){
        Random rn = new Random();
        int randomNumber = rn.nextInt(0, 1000);

        User user1 = new User();
        user1.setImageURL("qwrqwr");
        user1.setUsername("Starleken");
        user1.setRole("Admin");
        user1.setImageURL("https://source.unsplash.com/random/200x200?sig=" + randomNumber);

        User user2 = new User();
        user2.setImageURL("qwrqwr");
        user2.setUsername("Student");
        user2.setRole("Admin");
        user2.setImageURL("https://source.unsplash.com/random/200x200?sig=" + randomNumber);

        User savedUser1 = userService.create(user1);
        User savedUser2 = userService.create(user2);

        Project project = new Project();
        project.setName("Project: " + randomNumber);
        project.setDescription("Description: " + randomNumber);
        project.setURL("URL: github.com/Starleken/" + randomNumber);
        project.setImageURL("https://source.unsplash.com/random/200x200?sig=" + randomNumber);

        Project savedProject = projectService.create(project);

        Comment comment1 = new Comment();
        comment1.setUser(savedUser1);
        comment1.setMessage("Багов нет");
        comment1.setProject(savedProject);

        Comment comment2 = new Comment();
        comment2.setUser(savedUser2);
        comment2.setMessage("обычный комментарий");
        comment2.setProject(savedProject);

        Comment comment3 = new Comment();
        comment3.setUser(savedUser2);
        comment3.setMessage("Баги есть");
        comment3.setProject(savedProject);

        commentService.create(comment1);
        commentService.create(comment2);
        commentService.create(comment3);

        return "projects";
    }
}
