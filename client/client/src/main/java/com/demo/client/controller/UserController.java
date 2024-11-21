package com.demo.client.controller;

import com.demo.client.dto.UserReqestDto;
import com.demo.client.dto.UserResponseDto;
import com.demo.client.service.UserService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("user")
    public ResponseEntity<UserResponseDto> getUserDetails(@RequestParam @NotNull(message = "id must not be null") @Min(value = 1, message = "id must be at least 1") Integer userId) {
       try{
           UserResponseDto responseDto=service.getUserdetails(new UserReqestDto(userId));
           if(responseDto==null){
               throw new RuntimeException("Failed to fetch user details");
           }
           return ResponseEntity.ok(responseDto);

       } catch (RuntimeException e) {
           return ResponseEntity.badRequest().body(null);
       }

    }

}
