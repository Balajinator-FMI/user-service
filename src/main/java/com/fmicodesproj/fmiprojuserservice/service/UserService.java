package com.fmicodesproj.fmiprojuserservice.service;

import com.fmicodesproj.fmiprojuserservice.domain.*;

import java.util.List;

public interface UserService {
    UserIDResponse createUser(UserCreateRequest userCreateRequest);
    UserDataResponse getUserDataById(String id, Double lat, Double lon);
    List<SkinType> getAllSkinTypes();
    List<SkinDisease> getAllSkinDiseases();
}
