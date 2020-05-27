package com.wsbo.demo.testcase;

import com.wsbo.demo.DemoApplication;
import com.wsbo.demo.aop.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class AopTest {
    @Autowired
    Target target;

    @Test
    public void aopTest1() {
        target.targetMethod1();
    }

    @Test
    public void aopTest2() {
        target.targetMethod2();
    }

    @Test
    public void aopTest3() {
        System.out.println(target.targetMethod3());
    }

    @Test
    public void aopTest4() {
        System.out.println(target.targetMethod4());
    }


}
