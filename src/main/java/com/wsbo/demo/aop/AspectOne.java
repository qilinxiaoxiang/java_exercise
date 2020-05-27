package com.wsbo.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectOne {

    @Around("@annotation(Inner)")
    public Object processInner(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before inner in one");
        pjp.proceed();
        System.out.println("after inner in one");
        return "1i";
    }

    @Around("@annotation(Outer)")
    public void processOuter(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before outer in one");
        pjp.proceed();
        System.out.println("after outer in one");
//        return "1o";
    }
}
