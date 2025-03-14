package com.fmicodesproj.fmiprojuserservice.repository;

import com.fmicodesproj.fmiprojuserservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> { }
