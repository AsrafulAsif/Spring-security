package com.example.missyou.request;

import com.example.missyou.enums.DeviceType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserLoginRequest {
    @NotNull(message = "User name needed.")
    @Size(min = 4, max = 30, message = "The length of full name must be between 4 and 30 characters.")
    private String Username;
    private String phoneNumber;
    private String password;
    private String firebaseFCMToken;
    private DeviceType deviceType;

}
