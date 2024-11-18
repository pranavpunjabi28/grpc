package com.demo.client.serviceimpl;

import com.demo.client.dto.UserReqestDto;
import com.demo.client.dto.UserResponseDto;
import com.demo.client.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UserServiceImpl implements UserService {
    final RestClient restClient = RestClient.builder().baseUrl("http://localhost:8081").build();
    final String pathvariable = "/user";
    //.path does not insert any slashes

    @Override
    public UserResponseDto getUserdetails(UserReqestDto userId) {

       try{
           ResponseEntity<UserResponseDto> response = restClient
                   .get()
                   .uri(uriBuilder -> uriBuilder.path(pathvariable).queryParam("userId", userId.getUser_id()).build())
                   .retrieve().toEntity(UserResponseDto.class);

           if (response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
               return response.getBody();
           } else {
               throw new RuntimeException("Failed to fetch user details");
           }
       }catch (Exception e){
           throw new RuntimeException("unexpected error while forwarding rest request :" + e);
       }
    }
}
