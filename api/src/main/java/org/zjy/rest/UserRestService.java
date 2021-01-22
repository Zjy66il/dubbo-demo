package org.zjy.rest;

import org.zjy.common.RestResponse;
import org.zjy.dto.UserDTO;

import java.util.List;

public interface UserRestService {

    RestResponse<List<UserDTO>> getAllUser();

    RestResponse<UserDTO> getUserById(Integer id);

    RestResponse addUser(UserDTO userDTO);

    RestResponse updateUser(UserDTO userDTO);

    RestResponse deleteUser(Integer[] ids);
}
