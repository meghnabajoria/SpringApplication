package com.example.SessionOne.service;

import com.example.SessionOne.dta.MyApplicationDTA;
import com.example.SessionOne.dta.MyResponseDTO;


public interface UserService {
    boolean updateEmployee(MyApplicationDTA request, String id);
}
