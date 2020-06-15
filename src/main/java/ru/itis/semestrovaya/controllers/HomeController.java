package ru.itis.semestrovaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.semestrovaya.models.Entry;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.security.UserDetailsImpl;
import ru.itis.semestrovaya.services.EntryService;
import ru.itis.semestrovaya.services.UserService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    EntryService entryService;

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String getHomePage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        if(userDetails != null) {
            List<Entry> entries = entryService.getEntriesSortedByInterests(userService.getByUsername(userDetails.getUsername()));
            model.addAttribute("entries", entries);
        }
        else {
            List<Entry> entries = entryService.getList();
            model.addAttribute("entries", entries);
        }
        return "home";
    }

    @PostMapping("/like")
    public String getLike(@RequestParam("entryId") Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userService.getByUsername(userDetails.getUsername());
        user.getLikedEntries().add(entryService.getById(id));
        userService.save(user);
        return "redirect:/home";
    }

}

