package com.fmicodesproj.fmiprojuserservice.mapper;

import com.fmicodesproj.fmiprojuserservice.domain.UserCreateRequest;
import com.fmicodesproj.fmiprojuserservice.domain.UserDataResponse;
import com.fmicodesproj.fmiprojuserservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userRequestToUser(UserCreateRequest userCreateRequest);
}
