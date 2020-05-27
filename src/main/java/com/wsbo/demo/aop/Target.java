package com.wsbo.demo.aop;

import org.springframework.stereotype.Component;

@Component
public class Target {

    @Outer
    @Inner
    public void targetMethod1() {
        System.out.println("here's the target1");
    }

    @Inner
    @Outer
    public void targetMethod2() {
        System.out.println("here's the target2");
    }

    @Inner
    public int targetMethod3() {
        return 3;
    }

    @Outer
    public String targetMethod4() {
        return "abc";
    }
}
