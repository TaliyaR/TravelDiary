package ru.itis.semestrovaya;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.ApplicationScope;
import ru.itis.semestrovaya.processor.CustomBeanFactoryPostProcessor;

@SpringBootApplication
public class SemestrovayaApplication {

    @ApplicationScope
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }

    public static void main(String[] args) {
        SpringApplication.run(SemestrovayaApplication.class, args);
    }

}
