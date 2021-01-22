package org.zjy.restImpl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zjy.common.RestResponse;
import org.zjy.dto.UserDTO;
import org.zjy.rest.UserRestService;
import org.zjy.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Service
@DubboService(version = "1.0.0", protocol = {"rest"})
@Path("user")
public class UserRestServiceImpl implements UserRestService {

    @Autowired
    private UserService userService;

    @GET
    @Path("getOne")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public RestResponse<UserDTO> getUserById(@QueryParam("id") Integer id) {
        UserDTO userDTO = userService.getUserById(id);
        return RestResponse.success(userDTO);
    }

    @GET
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public RestResponse<List<UserDTO>> getAllUser() {
        List<UserDTO> userDTOList = userService.getAllUser();
        return RestResponse.success(userDTOList);
    }

    @POST
    @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public RestResponse addUser(UserDTO userDTO) {
        Boolean result = userService.addUser(userDTO);
        return RestResponse.success(result);
    }

    @POST
    @Path("update")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public RestResponse updateUser(UserDTO userDTO) {
        Boolean result = userService.updateUser(userDTO);
        return RestResponse.success(result);
    }

    @POST
    @Path("delete")
    @Override
    public RestResponse deleteUser(Integer[] ids) {
        Boolean result = userService.deleteUser(ids);
        return RestResponse.success(result);
    }
}
