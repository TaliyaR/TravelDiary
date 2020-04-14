package ru.itis.semestrovaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semestrovaya.dto.EntryDto;
import ru.itis.semestrovaya.models.Entry;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.security.UserDetailsImpl;
import ru.itis.semestrovaya.services.EntryServiceImpl;

import java.util.Set;
@Controller
public class DiaryController {

//    @Autowired
//    EntryServiceImpl entryService;

//    @GetMapping("/diary")
//    public String getDiaryPage(@AuthenticationPrincipal UserDetailsImpl userDetails){
//        User user = userDetails.getUser();
//        Set<Entry> usersEntries = user.getEntries();
//        return "redirect:/diary";
//    }

    @GetMapping("/diaries")
    public String getDiaryPage(){
        return "diaries";
    }

//    @PostMapping("/diary")
//    public String deleteEntry(Entry entry){
//        entryService.delete(entry);
//        return "redirect:/diary";
//
//    }




}
