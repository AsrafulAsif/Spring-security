package com.example.missyou.response.rest;

import com.example.missyou.response.SimpleResponseRest;
import com.example.missyou.response.AppUserResponse;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseRest  extends SimpleResponseRest {
    private List<AppUserResponse> userResponse;
}
