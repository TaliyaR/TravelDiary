package ru.itis.semestrovaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semestrovaya.dto.EntryDto;
import ru.itis.semestrovaya.services.EntryService;
import ru.itis.semestrovaya.services.TagService;

@Controller
public class EntryController {

    @Autowired
    EntryService entryService;

    @Autowired
    TagService tagService;

    @GetMapping("/entry")
    public String getEditPage(Model model) {
        model.addAttribute("tags", tagService.getAll());
        return "entry";
    }

    @PostMapping("/entry")
    public String addEntry(EntryDto form) {
        entryService.save(form);
        return "redirect:/diaries";
    }

}
