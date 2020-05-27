package com.wsbo.demo.testcase;

import com.wsbo.demo.DemoApplication;
import com.wsbo.demo.aop.Animal;
import com.wsbo.demo.service.BoxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class NewBarkTest {
    @Resource
    private Animal animal;

    @Autowired
    private BoxService boxService;

    @Test
    public void barkTest() {
        System.out.println(boxService.bBox());
    }
}
