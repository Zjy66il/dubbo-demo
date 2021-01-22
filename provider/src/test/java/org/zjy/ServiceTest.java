package org.zjy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.zjy.common.RestResponse;
import org.zjy.dto.UserDTO;
import org.zjy.rest.UserRestService;
import org.zjy.service.UserService;

import java.util.List;

@ContextConfiguration(locations = { "classpath*:applicationContext.xml"})
@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRestService userRestService;

    @Test
    public void testGetAll(){
/*        List<UserDTO> userDTOList = userService.getAllUser();
        for (UserDTO userDTO : userDTOList){
            System.out.println(userDTO.getName());
        }*/

        RestResponse<List<UserDTO>> res = userRestService.getAllUser();
        System.out.println(res.toString());
    }

    @Test
    public void testGetById(){
/*
        UserDTO userDTO = userService.getUserById(1);
*/
        RestResponse<UserDTO> res = userRestService.getUserById(1);
        System.out.println(res.toString());
    }

    @Test
    public void testAddUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName("test");
        userDTO.setAge(20);
        userDTO.setPassword("test");

        System.out.println(userService.addUser(userDTO));
    }

    @Test
    public void testUpdateUser(){
        UserDTO userDTO = userService.getUserById(6);
        userDTO.setAge(30);

        System.out.println(userService.updateUser(userDTO));
    }

    @Test
    public void testDel(){
        Integer[] list = {7};
        System.out.println(userService.deleteUser(list));
    }
}
