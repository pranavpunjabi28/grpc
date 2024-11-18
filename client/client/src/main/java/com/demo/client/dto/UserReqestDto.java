package com.demo.client.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserReqestDto {

    @Min(value = 1, message = "User Id should be greater than 0")
    @Max(value = 100, message = "User Id should be less than 100")
    @NotBlank(message = "User Id should not be blank")
    private int user_id;


}
