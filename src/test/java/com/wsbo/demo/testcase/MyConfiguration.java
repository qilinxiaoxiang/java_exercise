package com.wsbo.demo.testcase;

import com.wsbo.demo.service.BoxService;
import org.mockito.Mockito;

//@Configuration
//@Profile("barktest")
public class MyConfiguration {
    //    @Bean
//    @Primary
    public BoxService boxService() {
        return Mockito.mock(BoxService.class);
    }
}
