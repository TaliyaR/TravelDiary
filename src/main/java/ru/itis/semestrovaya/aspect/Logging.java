package ru.itis.semestrovaya.aspect;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    @After("saveReader()")
    public void after(JoinPoint joinPoint) {
        Object[] lArgs = joinPoint.getArgs();
        UserDto user = (UserDto) lArgs[0];
        logger.info("New user| username: " + user.getUsername());
    }

    @SneakyThrows
    @Around("saveReader()")
    public Object time(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
        return object;
    }

    @AfterThrowing(pointcut = "saveReader()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(ClassCastException e) {
        System.out.println("We have an exception here: " + e.toString());
    }

}