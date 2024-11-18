package com.demo.grpc.controller;

import com.demo.grpc.dto.UserRequestDto;
import com.demo.grpc.dto.UserResponseDto;
import com.demo.grpc.exceptions.ServerException;
import com.demo.grpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping(value = "user")
    public UserResponseDto getUserDetails(int userId) {
        try {
            UserResponseDto user = service.getUserdetails(new UserRequestDto(userId));
            return user;
        } catch (ServerException e) {
            throw new ServerException("Error occurred while fetching user details");
        }catch (Exception e){
            throw new RuntimeException("unexpected error" + e);
        }
    }
}