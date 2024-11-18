package com.demo.grpc.mapper;


import com.demo.grpc.dto.UserRequestDto;
import com.example.grpc.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRequestMapper {

    UserRequestMapper instance = Mappers.getMapper(UserRequestMapper.class);

    UserRequest toUserRequest(UserRequestDto userReqestDto);
}
