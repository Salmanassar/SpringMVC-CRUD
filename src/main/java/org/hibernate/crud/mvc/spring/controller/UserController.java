package org.hibernate.crud.mvc.spring.controller;

import org.hibernate.crud.mvc.spring.model.User;
import org.hibernate.crud.mvc.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class UserController {

    public UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserController() {
    }

    @GetMapping("/start")
    public String getAllList(ModelMap modelMap) {
        List<User> userList = userService.usersList();
        modelMap.addAttribute("listUsers", userList);
        return "listUsers";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Integer> id) {
        if (id.isPresent()) {
            User user = userService.readUser(id.get());
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", new User());
        }
        return "add-edit-users";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/updateUser", method = RequestMethod.POST)
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}


