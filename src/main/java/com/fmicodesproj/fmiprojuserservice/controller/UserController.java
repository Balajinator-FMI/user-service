package com.fmicodesproj.fmiprojuserservice.controller;

import com.fmicodesproj.fmiprojuserservice.domain.SkinDisease;
import com.fmicodesproj.fmiprojuserservice.domain.SkinType;
import com.fmicodesproj.fmiprojuserservice.domain.UserDTO;
import com.fmicodesproj.fmiprojuserservice.domain.UserIDResponse;
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
    public ResponseEntity<UserDTO> getUserDataById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserDataById(id));
    }

    @PostMapping
    public ResponseEntity<UserIDResponse> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @GetMapping("/skin-types")
    public ResponseEntity<List<SkinType>> getAllSkinTypes() {
        return ResponseEntity.ok(userService.getAllSkinTypes());
    }

    @GetMapping("/skin-diseases")
    public ResponseEntity<List<SkinDisease>> getAllSkinDiseases() {
        return ResponseEntity.ok(userService.getAllSkinDeseases());
    }
}
