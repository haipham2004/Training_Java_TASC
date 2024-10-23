package com.example.Demo_Spring_Framework.introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class MessengerServiceImp implements MessageService{

    @PostConstruct
    public void Starts(){
        System.out.println("PostConstruct mess: "+getClass().getSimpleName());
    }

    @PreDestroy
    public void ends(){
        System.out.println("PreDestroy mess: "+getClass().getSimpleName());
    }
    public MessengerServiceImp(){
        System.out.println("Class: "+getClass().getSimpleName());
    }
    @Override
    public String message() {
        return "Message Messenger";
    }
}
