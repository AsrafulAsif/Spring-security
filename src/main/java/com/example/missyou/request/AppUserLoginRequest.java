package com.example.missyou.request;

import com.example.missyou.enums.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserLoginRequest {
    private String Username;
    private String phoneNumber;
    private String password;
    private String firebaseFCMToken;
    private DeviceType deviceType;

}
