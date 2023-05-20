package com.example.missyou.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("app-user")
public class AppUser {
    @Id
    private String id;
    private String userName;
    private  String phoneNumber;
    private String password;
    private String firebaseFCMToken;
}
