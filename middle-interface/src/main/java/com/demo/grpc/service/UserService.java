package com.demo.grpc.service;

import com.demo.grpc.GrpcApplication;

import com.demo.grpc.dto.UserRequestDto;
import com.demo.grpc.dto.UserResponseDto;
import com.demo.grpc.exceptions.ServerException;
import com.example.grpc.UserServiceGrpc;
import jakarta.validation.Valid;

public interface UserService {
    UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub =UserServiceGrpc.newBlockingStub(GrpcApplication.channel);

     UserResponseDto getUserdetails( UserRequestDto userReqestDto) throws ServerException;
}
