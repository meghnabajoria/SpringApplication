package com.example.SessionOne.service.impl;

import com.example.SessionOne.dta.MyApplicationDTA;
import com.example.SessionOne.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceimpl implements UserService {

    public UserServiceimpl(){
        System.out.println("inside userserive constrcutor");
    }
    @PostConstruct
    public void init(){
        System.out.println("inside userservicd postconstructor");
    }


    @Override
    public boolean updateEmployee(MyApplicationDTA request, String id){
        //process
        return false;
    }

}
