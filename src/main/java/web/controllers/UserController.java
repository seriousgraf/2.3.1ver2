package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String displayAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/show_all_users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "users/show_user";
    }

    @GetMapping("/new")
    public String showCreateUserPage(Model model) {
        model.addAttribute("user", new User());
        return "users/create_user";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "users/update_user";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/users";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
