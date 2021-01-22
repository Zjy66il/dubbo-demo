package org.zjy.service;

import org.zjy.dto.UserDTO;

import java.util.List;

public interface UserService {

    /**
     * 获得所有User
     * @return
     */
    List<UserDTO> getAllUser();

    Boolean addUser(UserDTO userDTO);

    UserDTO getUserById(Integer id);

    Boolean updateUser(UserDTO userDTO);

    Boolean deleteUser(Integer[] ids);


}
