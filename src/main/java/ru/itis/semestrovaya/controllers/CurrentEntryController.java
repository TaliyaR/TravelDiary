package ru.itis.semestrovaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.semestrovaya.services.EntryService;

@Controller
public class CurrentEntryController {

    @Autowired
    EntryService entryService;

    @GetMapping("/currentEntry")
    public String getPage(@RequestParam("entryId") Long id, Model model){
        model.addAttribute("entry", entryService.getById(id));
        return "currentEntry";
    }
}
