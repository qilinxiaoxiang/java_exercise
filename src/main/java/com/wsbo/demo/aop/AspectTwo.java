package com.wsbo.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order
public class AspectTwo {
    @Around("@annotation(Inner)")
    public Object processInner(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before inner in two");
        pjp.proceed();
        System.out.println("after inner in two");
        return "2i";
    }

    @Around("@annotation(Outer)")
    public Object processOuter(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before outer in two");
        pjp.proceed();
        System.out.println("after outer in two");
        return "2o";
    }
}
