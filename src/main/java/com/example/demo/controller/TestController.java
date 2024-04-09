package com.example.demo.controller;

import com.example.demo.model.CustomerRequest;
import com.example.demo.model.CustomerType;
import com.example.demo.model.Order;
import com.example.demo.model.Student;
import com.example.demo.service.CustomerCategorizeService;
import com.example.demo.service.OrderService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {

    @Autowired
    CustomerCategorizeService customerCategorizeService;


    @Autowired
    OrderService orderService;

    @Autowired
    StudentService studentService;
    @PostMapping("/test")
    public ResponseEntity<CustomerType> getCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerType customerType = customerCategorizeService.getCustomerType(customerRequest);
        return new ResponseEntity<>(customerType, HttpStatus.OK);
    }




    @PostMapping("/order")
    public void order(@RequestBody Order order) {
        orderService.getOrder(order);
    }






    @PostMapping("/student")
    public void student(@RequestBody Student student) {
        studentService.student(student);
    }










//    @GetMapping("/test")
//    public  String test(){
//
//
//        return "hello";
//    }

}
