package ru.itis.semestrovaya.controllers;

import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.semestrovaya.models.Entry;
import ru.itis.semestrovaya.security.UserDetailsImpl;
import ru.itis.semestrovaya.services.EntryServiceImpl;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    EntryServiceImpl entryService;

    @GetMapping("/home")
    public String getHomePage(@AuthenticationPrincipal User user, Model model) {
        if(user != null) {
            //TODO по тэгам
            List<Entry> entries = entryService.getList();
            model.addAttribute("entries", entries);
        }else {
            List<Entry> entries = entryService.getList();
            model.addAttribute("entries", entries);
        }
        return "home";
    }

}
