package com.demo.grpc.ServiceImpl;

import com.demo.grpc.dto.UserRequestDto;
import com.demo.grpc.dto.UserResponseDto;
import com.demo.grpc.exceptions.ServerException;
import com.demo.grpc.mapper.UserRequestMapper;
import com.demo.grpc.mapper.UserResponseMapper;
import com.demo.grpc.service.UserService;
import com.example.grpc.UserRequest;
import com.example.grpc.UserResponse;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger=LoggerFactory.getLogger(UserService.class);

    @Override
    public UserResponseDto getUserdetails(UserRequestDto userReqestDto) throws ServerException {

        UserRequest request=UserRequestMapper.instance.toUserRequest(userReqestDto);

        try{
            UserResponse res= userServiceBlockingStub.getUserDetails(request);
            return UserResponseMapper.instance.toUserResponseDto(res);
        }catch (StatusRuntimeException e){
            logger.error("Fail to make rpc call {}", e.getStatus());
            throw new ServerException("fail to make rpc call :"+e.getMessage());
        }
    }
}
