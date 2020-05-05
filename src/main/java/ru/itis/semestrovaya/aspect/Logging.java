package ru.itis.semestrovaya.aspect;

import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.itis.semestrovaya.dto.UserDto;


@Aspect
@Component
public class Logging {

    private Logger logger = LoggerFactory.getLogger("userLoggerDb");

    @Pointcut("execution(* ru.itis.semestrovaya.services.SignUpServiceImpl.signUp(..))")
    public void saveReader() {
    }

    @Before("saveReader()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("before " + joinPoint.toString());
        System.out.println("Create user's profile.");
    }

    @AfterReturning("saveReader()")
    public void afterReturningAdvice(JoinPoint joinPoint) {
        Object[] lArgs = joinPoint.getArgs();
        UserDto user = (UserDto) lArgs[0];
        logger.info("New user| username: " + user.getUsername());
    }

    @AfterThrowing(pointcut = "saveReader()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(ClassCastException e) {
        System.out.println("We have an exception here: " + e.toString());
    }

}