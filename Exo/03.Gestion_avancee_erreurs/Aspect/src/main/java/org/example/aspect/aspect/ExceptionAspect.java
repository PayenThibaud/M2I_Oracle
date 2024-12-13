package org.example.aspect.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    @Pointcut("@annotation(org.example.aspect.annotation.ExceptionAspect)")
    public void exceptionPointCut(){
    }

    @AfterThrowing(pointcut = "exceptionPointCut()", throwing = "exception")
    public void handleException(JoinPoint joinPoint, Throwable exception) {
        System.out.println("Erreur methode : " + joinPoint.getSignature());
        System.out.println("Erreur message : " + exception.getMessage());
    }
}

