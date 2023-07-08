package com.example.missyou.repository;

import com.example.missyou.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository extends MongoRepository<AppUser,String> {
    AppUser findByUserNameAndUserPhoneNumber(String userName,String phoneNumber);
}
