package ru.itis.semestrovaya;

import bell.oauth.discord.main.OAuthBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootApplication
public class SemestrovayaApplication {

    @Bean
    public OAuthBuilder oAuthBuilder() {
        OAuthBuilder builder = new OAuthBuilder("709842682574405763", "wOjLzNhEpiG9IoTXndzRR3l9TfzbDOtH")
                .setScopes(new String[]{"connections", "guilds", "email"})
                .setRedirectURI("http://localhost:8080/discordAuth");
        return builder;
    }

    @ApplicationScope
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


    public static void main(String[] args) {
        SpringApplication.run(SemestrovayaApplication.class, args);
    }

}
