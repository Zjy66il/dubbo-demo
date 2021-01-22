package org.zjy;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zjy.common.RestResponse;
import org.zjy.dto.UserDTO;
import org.zjy.rest.UserRestService;
import org.zjy.service.UserService;

import java.util.List;

public class RestConsumer {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer(rest) start");
        UserRestService demoService = context.getBean(UserRestService.class);
        System.out.println("consumer");
        RestResponse<List<UserDTO>> res = demoService.getAllUser();
        System.out.println(res.toString());
    }
}
