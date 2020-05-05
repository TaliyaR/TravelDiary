package ru.itis.semestrovaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.security.UserDetailsImpl;
import ru.itis.semestrovaya.services.UserService;

import java.util.List;

@RequestScope
@Controller
public class AdminPageController {

    @Autowired
    UserService userService;

    @GetMapping("/admin")
    public String getProfilePage(Model model){
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "admin";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(userService.getById(id));
        return "redirect:/admin";
    }
}
