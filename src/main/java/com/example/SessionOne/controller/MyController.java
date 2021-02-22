package com.example.SessionOne.controller;

import com.example.SessionOne.dta.MyApplicationDTA;
import com.example.SessionOne.dta.MyResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "success!!";
    }

    @PostMapping(path = "/hello-rest-api")
    public String hellorestapi(){
        return "hello rest api";
    }

    @GetMapping(path = "/hello-query")
    public String helloQuery(@RequestParam String query){
        return "query " +  query;
    }

    @PostMapping(value = "/regist")
    public String registerUser(@RequestBody MyApplicationDTA request){
        return request.toString();
    }

    @GetMapping(path = "/employee/{employeeId}")
    public MyResponseDTO getEmployeeDetails(@PathVariable String employeeId){
        MyResponseDTO response = new MyResponseDTO();
        response.setId(employeeId);
        return response;
    }

}
