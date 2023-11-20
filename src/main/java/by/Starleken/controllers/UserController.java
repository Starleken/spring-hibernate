package by.Starleken.controllers;

import by.Starleken.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getSortByMessages(Model model){
        model.addAttribute("users", userService.findUsersSortByComments());
        return "users";
    }
}
