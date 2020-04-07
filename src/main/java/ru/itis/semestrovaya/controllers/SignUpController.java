package ru.itis.semestrovaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semestrovaya.dto.UserDto;
import ru.itis.semestrovaya.services.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String signUp(UserDto form){
        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}
