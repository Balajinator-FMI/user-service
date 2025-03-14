package com.fmicodesproj.fmiprojuserservice.service.impl;

import com.fmicodesproj.fmiprojuserservice.domain.SkinDisease;
import com.fmicodesproj.fmiprojuserservice.domain.SkinType;
import com.fmicodesproj.fmiprojuserservice.domain.UserDTO;
import com.fmicodesproj.fmiprojuserservice.domain.UserIDResponse;
import com.fmicodesproj.fmiprojuserservice.entity.User;
import com.fmicodesproj.fmiprojuserservice.mapper.UserMapper;
import com.fmicodesproj.fmiprojuserservice.repository.UserRepository;
import com.fmicodesproj.fmiprojuserservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserIDResponse createUser(UserDTO userDTO) {
        User user = userRepository.save(UserMapper.INSTANCE.userRequestToUser(userDTO));
        return UserIDResponse.builder().id(user.getId()).build();
    }

    @Override
    public UserDTO getUserDataById(String id) {
        return UserMapper.INSTANCE.userToUserRequest(userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found")
        ));
    }

    @Override
    public List<SkinType> getAllSkinTypes() {
        return List.of(SkinType.values());
    }

    @Override
    public List<SkinDisease> getAllSkinDeseases() {
        return List.of(SkinDisease.values());
    }
}
