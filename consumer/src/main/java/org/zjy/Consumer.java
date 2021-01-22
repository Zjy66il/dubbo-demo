package org.zjy;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zjy.dto.UserDTO;
import org.zjy.service.UserService;

import java.util.List;

public class Consumer {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer(dubbo) start");
        UserService demoService = context.getBean(UserService.class);
        System.out.println("consumer");
        List<UserDTO> userDTOList = demoService.getAllUser();
        for(UserDTO userDTO : userDTOList){
            System.out.println(userDTO.getName());
            System.out.println(userDTO.getAge());
            System.out.println();
        }
    }
}
