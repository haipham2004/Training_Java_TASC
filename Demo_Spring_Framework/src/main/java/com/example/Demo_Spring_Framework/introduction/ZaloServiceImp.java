package com.example.Demo_Spring_Framework.introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class ZaloServiceImp implements MessageService{

    @PostConstruct
    public void Starts(){
        System.out.println("PostConstruct zalo: "+getClass().getSimpleName());
    }

    @PreDestroy
    public void ends(){
        System.out.println("PreDestroy zalo: "+getClass().getSimpleName());
    }
    public ZaloServiceImp(){
        System.out.println("Class: "+getClass().getSimpleName());
    }
    @Override
    public String message() {
        return "Message zalo";
    }
}
