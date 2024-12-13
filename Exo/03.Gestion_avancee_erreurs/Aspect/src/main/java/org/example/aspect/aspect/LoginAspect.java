package org.example.aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

    @Pointcut("@annotation(org.example.aspect.annotation.LogginAspect)")
    public void aroundPointCut(){

    }

    @Before("aroundPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Entrée dans la méthode : " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "aroundPointCut()")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("Sortie de la méthode : " + joinPoint.getSignature());
    }
}
