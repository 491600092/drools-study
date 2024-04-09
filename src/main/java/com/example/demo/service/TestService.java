package com.example.demo.service;

import com.example.demo.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service("testService")
@Slf4j
public class TestService {

    public  void  save(){
        System.out.println("-----------------");
        System.out.println("11111111111111111");
        System.out.println("-----------------");
    }



}