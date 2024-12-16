package org.example.aspect2.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Aspect
@Component
public class LoginAspect {
    @Pointcut("@annotation(org.example.aspect2.annotation.LoginAspect)")
    public void loginPointCut() {

    }

    @Before("loginPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        System.out.println("Methode : " + joinPoint.getSignature());
        System.out.println("URI : " + request.getRequestURI() + ", Methode : " + request.getMethod() + ", date : " + LocalDateTime.now());
    }



}
