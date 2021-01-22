package org.zjy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.zjy.dto.UserDTO;
import org.zjy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private String prefix = "user/";

    @RequestMapping(value="/getAllUser")
    public String getAllUser(ModelMap modelMap){
        modelMap.put("userModelList", userService.getAllUser());
        return prefix + "user_list";
    }

    @RequestMapping(value="/getUserDetailForm")
    public String getUserDetailForm(ModelMap modelMap, Integer id){
        if (id != null){
            modelMap.put("userModel", userService.getUserById(id));
        }
        return prefix + "user_detail";
    }

    @RequestMapping(value="/addUser")
    public String addUser(UserDTO userModel){
        userService.addUser(userModel);
        return "redirect:getAllUser";
    }

    @RequestMapping(value="/updateUser")
    public String updateUser(UserDTO userModel){
        userService.updateUser(userModel);
        return "redirect:getAllUser";
    }

    @RequestMapping(value="/deleteUser")
    @ResponseBody
    public boolean deleteUser(@RequestParam(value = "ids[]") Integer[] ids){
        userService.deleteUser(ids);
        return true;
    }


}
