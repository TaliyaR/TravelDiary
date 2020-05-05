package ru.itis.semestrovaya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import ru.itis.semestrovaya.filters.CustomFilter;
import ru.itis.semestrovaya.models.Role;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.repositories.UsersRepository;

import java.security.Principal;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(value = "customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    CustomFilter customFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.addFilterAfter(customFilter, FilterSecurityInterceptor.class);

        http.authorizeRequests()
                .antMatchers("/home", "/signUp").permitAll()
                .antMatchers("/profile", "/diaries", "/entry").authenticated()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .and()
                .oauth2Login().loginPage("/signIn");
        http.formLogin()
                .loginPage("/signIn")
                .usernameParameter("username")
                .defaultSuccessUrl("/profile")
                .failureUrl("/signIn?error")
                .permitAll();

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/signIn");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public PrincipalExtractor principalExtractor(UsersRepository repository) {
        return map -> {
            Long id = (Long) map.get("sub");

            User user = repository.findById(id).orElseGet(() -> {
                User newUser = User.builder()
                        .googleId(id)
                        .firstName((String) map.get("given_name"))
                        .lastName((String) map.get("family_name"))
                        .email((String) map.get("email"))
                        .role(Role.USER)
                        .build();
                return newUser;
            });
            return repository.save(user);
        };
    }
}
