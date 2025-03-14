package com.fmicodesproj.fmiprojuserservice.mapper;

import com.fmicodesproj.fmiprojuserservice.domain.UserDTO;
import com.fmicodesproj.fmiprojuserservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userRequestToUser(UserDTO userDTO);
    UserDTO userToUserRequest(User user);
}
