package com.fmicodesproj.fmiprojuserservice.controller;

import com.fmicodesproj.fmiprojuserservice.domain.*;
import com.fmicodesproj.fmiprojuserservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDataResponse> getUserDataById(@PathVariable String id, @RequestParam Double lat, @RequestParam Double lon) {
        return ResponseEntity.ok(userService.getUserDataById(id, lat, lon));
    }

    @PostMapping
    public ResponseEntity<UserIDResponse> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok(userService.createUser(userCreateRequest));
    }

    @GetMapping("/skin-types")
    public ResponseEntity<List<SkinType>> getAllSkinTypes() {
        return ResponseEntity.ok(userService.getAllSkinTypes());
    }

    @GetMapping("/skin-diseases")
    public ResponseEntity<List<SkinDisease>> getAllSkinDiseases() {
        return ResponseEntity.ok(userService.getAllSkinDiseases());
    }
}
