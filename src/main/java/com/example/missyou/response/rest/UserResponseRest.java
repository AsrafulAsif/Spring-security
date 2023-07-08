package com.example.missyou.response.rest;

import com.example.missyou.response.SampleResponse;
import com.example.missyou.response.AppUserResponse;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseRest  extends SampleResponse {
    private List<AppUserResponse> userResponse;
}
