package org.zjy.serviceImpl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zjy.common.UserMapper;
import org.zjy.dto.UserDTO;
import org.zjy.entity.TUser;
import org.zjy.mapper.TUserMapper;
import org.zjy.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@DubboService(version = "1.0.0", protocol = {"dubbo"})
public class UserServiceImpl implements UserService{
    @Autowired
    private TUserMapper userMapper;

    @Override
    public List<UserDTO> getAllUser() {
        List<TUser> userList = userMapper.selectByExample(null);

        List<UserDTO> userDTOList = userList.stream().map(user -> {
            UserDTO deptDTO =  UserMapper.INSTANCE.convert(user);
            return deptDTO;
        }).collect(Collectors.toList());
        return userDTOList;

/*        List<UserDTO> userDTOList = new ArrayList<>();
        for (TUser userEntity : userList){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(userEntity.getId());
            userDTO.setName(userEntity.getName());
            userDTO.setAge(userEntity.getAge());
            userDTOList.add(userDTO);
        }
        return userDTOList;*/
    }

    @Override
    public UserDTO getUserById(Integer id) {
        TUser user = userMapper.selectByPrimaryKey(id);
        UserDTO userDTO =  UserMapper.INSTANCE.convert(user);
        return userDTO;
    }

    @Override
    public Boolean addUser(UserDTO userDTO) {
        TUser user = UserMapper.INSTANCE.convert(userDTO);
        Integer result = userMapper.insertSelective(user);
        return 1 == result ? true : false;

        /*TUser userEntity = new TUser();
        userEntity.setName(userDTO.getName());
        userEntity.setAge(userDTO.getAge());
        userEntity.setPassword(userDTO.getPassword());
        Integer result = userMapper.insertSelective(userEntity);
        return 1 == result ? true : false;*/
    }

    @Override
    public Boolean updateUser(UserDTO userDTO) {
        TUser user = UserMapper.INSTANCE.convert(userDTO);
        Integer result = userMapper.updateByPrimaryKeySelective(user);
        return result > 0;
    }

    @Override
    public Boolean deleteUser(Integer[] ids) {
        Integer result = null;
        for (Integer id : ids){
            result = userMapper.deleteByPrimaryKey(id);
            if (result == 0){
                break;
            }
        }
        return 1 == result ? true : false;
    }
}
