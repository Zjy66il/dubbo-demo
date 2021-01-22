package org.zjy.common;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.zjy.dto.UserDTO;
import org.zjy.entity.TUser;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO convert(TUser user);

    TUser convert(UserDTO userDTO);
}
