package ru.itis.semestrovaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semestrovaya.dto.PassForm;
import ru.itis.semestrovaya.dto.UserDto;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.security.UserDetailsImpl;
import ru.itis.semestrovaya.services.ProfileServiceImpl;

@Controller
public class ProfileController {

    @Autowired
    ProfileServiceImpl profileService;

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model){
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/profile")
    public String editProfile(UserDto form){
        profileService.edit(form);
        return "redirect:/profile";
    }

    @PostMapping("/profile_pass")
    public String changePassword(PassForm form){
        profileService.changePassword(form);
        return "redirect:/profile";
    }
}
