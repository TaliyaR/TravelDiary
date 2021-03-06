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

import java.util.List;

@Controller
public class DiaryController {

    @Autowired
    EntryService entryService;

    @GetMapping("/diaries")
    public String getDiaryPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model){
        User user = userDetails.getUser();
        List<Entry> entries = entryService.getList(user);
        model.addAttribute("entries", entries);
        return "diaries";
    }

    @PostMapping("/delete")
    public String deleteEntry(@RequestParam("entryId") Long id){
        entryService.deleteById(id);
        return "redirect:/diaries";
    }

}
