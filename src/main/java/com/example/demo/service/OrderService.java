package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {


    private final KieContainer kieContainer;



//    private final KieContainer kieContainer;
    public OrderService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }



    public  void  getOrder(Order order){
        log.info("执行规则前的订单信息：{}",order);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(order);
        kieSession.fireAllRules();
        kieSession.dispose();
        log.info("执行规则后的订单信息：{}",order);

    }









}