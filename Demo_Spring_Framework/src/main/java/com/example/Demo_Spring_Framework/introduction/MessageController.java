package com.example.Demo_Spring_Framework.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.Demo_Spring_Framework.introduction")
public class MessageController {

    private MessageService messenger;
    private MessageService zalo;



    @Autowired
    public MessageController(@Qualifier("messengerServiceImp") MessageService messenger,
                       @Qualifier("zaloServiceImp") MessageService zalo
    ) {
        this.messenger = messenger;
        this.zalo = zalo;
    }

    public void disPlayZalo(){
        System.out.println("zalo: "+zalo.message());
    }

    public void disPlayMess(){
        System.out.println("mess: "+messenger.message());
    }



    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageController.class);
        MessageController messageController = context.getBean(MessageController.class);
        messageController.disPlayZalo();
        messageController.disPlayMess();
    }


}
