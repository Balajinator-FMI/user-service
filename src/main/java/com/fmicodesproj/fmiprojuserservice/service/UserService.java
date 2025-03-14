package com.fmicodesproj.fmiprojuserservice.service;

import com.fmicodesproj.fmiprojuserservice.domain.SkinDisease;
import com.fmicodesproj.fmiprojuserservice.domain.SkinType;
import com.fmicodesproj.fmiprojuserservice.domain.UserDTO;
import com.fmicodesproj.fmiprojuserservice.domain.UserIDResponse;

import java.util.List;

public interface UserService {
    UserIDResponse createUser(UserDTO userDTO);
    UserDTO getUserDataById(String id);
    List<SkinType> getAllSkinTypes();
    List<SkinDisease> getAllSkinDeseases();
}
