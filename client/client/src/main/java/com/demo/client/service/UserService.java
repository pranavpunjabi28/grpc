package com.demo.client.service;

import com.demo.client.dto.UserReqestDto;
import com.demo.client.dto.UserResponseDto;
import jakarta.validation.Valid;

public interface UserService {
    public UserResponseDto getUserdetails(@Valid UserReqestDto userId);
}
