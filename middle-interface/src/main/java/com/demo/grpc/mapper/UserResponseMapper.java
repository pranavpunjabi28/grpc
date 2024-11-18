package com.demo.grpc.mapper;

import com.demo.grpc.dto.UserResponseDto;
import com.example.grpc.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResponseMapper {
    UserResponseMapper instance= Mappers.getMapper(UserResponseMapper.class);

    UserResponseDto toUserResponseDto(UserResponse userResponse);
}
