package org.example.aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {
    @Pointcut("@annotation(org.example.aspect.annotation.PerformanceAspect)")
    public void performancePointCut(){

    }

    @Around("performancePointCut()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long tempsStart = System.nanoTime();
        System.out.println("Temps de départ : " + tempsStart );

        Object result = joinPoint.proceed();

        long tempsFin= System.nanoTime();
        System.out.println("Temps de fin : " + tempsFin );

        long tempsDiff = (tempsFin - tempsStart);
        System.out.println("Temps d'exécution : " + tempsDiff + " nanoseconds");

        return result;
    }
}
