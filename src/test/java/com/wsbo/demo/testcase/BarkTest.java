package com.wsbo.demo.testcase;

import com.wsbo.demo.DemoApplication;
import com.wsbo.demo.service.BoxService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BarkTest {
    @Autowired
    BoxService boxService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void barkTest() {
        Mockito.when(boxService.bBox()).thenReturn("abc");
        System.out.println(boxService.bBox());
    }

    @Configuration
    static class MyConfiguration {
        @Bean
        @Primary
        public BoxService boxService() {
            return Mockito.mock(BoxService.class);
        }
    }

}
