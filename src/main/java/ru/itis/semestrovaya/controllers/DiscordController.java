package ru.itis.semestrovaya.controllers;

import bell.oauth.discord.main.OAuthBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.security.UserDetailsImpl;
import ru.itis.semestrovaya.services.UserService;

import java.io.IOException;

@Controller
public class DiscordController {

    @Autowired
    OAuthBuilder builder;

    @Autowired
    UserService userService;

    @GetMapping("/discordAuth")
    public ModelAndView getDiscordAuth(@RequestParam("code") String code) throws IOException {
        builder.exchange(code);
        User user = userService.getUserByEmail(builder.getUser().getEmail());
        if (user == null) {
            return new ModelAndView("redirect:signIn");
        } else {
            UserDetailsImpl userDetails = new UserDetailsImpl(user);
            UsernamePasswordAuthenticationToken token
                    = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(token);
            return new ModelAndView("redirect:profile");
        }
    }
}

