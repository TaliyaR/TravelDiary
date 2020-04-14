package ru.itis.semestrovaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semestrovaya.dto.EntryDto;
import ru.itis.semestrovaya.security.UserDetailsImpl;
import ru.itis.semestrovaya.services.EntryService;
import ru.itis.semestrovaya.services.EntryServiceImpl;

public class EntryController {

    @Autowired
    EntryServiceImpl entryService;

    @GetMapping
    public String getEditPage(){
        return "";
    }

    @PostMapping()
    public String addEntry(@AuthenticationPrincipal UserDetailsImpl userDetails, EntryDto form){
        entryService.save(form);
        return "redirect:/diaries";
    }
}
