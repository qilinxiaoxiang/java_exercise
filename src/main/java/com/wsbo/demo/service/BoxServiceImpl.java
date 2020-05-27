package com.wsbo.demo.service;

import org.springframework.stereotype.Service;

@Service
public class BoxServiceImpl implements BoxService {
    @Override
    public String bBox() {
        return "beat";
    }
}
