package ru.itis.semestrovaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.semestrovaya.dto.UserDto;
import ru.itis.semestrovaya.services.SignUpService;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid UserDto form,
                         BindingResult result, Model model){
        if(result.hasErrors()){
//            attributes.addFlashAttribute("error", result.getAllErrors().get(0).getDefaultMessage());
            model.addAttribute("error", result.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/signUp";
        }
        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}
