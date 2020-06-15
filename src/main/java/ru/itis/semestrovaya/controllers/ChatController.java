package ru.itis.semestrovaya.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.semestrovaya.security.UserDetailsImpl;

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String getChatPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model){
        model.addAttribute("user", userDetails.getUser());
        return "chat";
    }
}
