package com.example.SessionOne.controller;

import com.example.SessionOne.dto.MyRequestDTO;
import com.example.SessionOne.dto.MyResponseDTO;
import com.example.SessionOne.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author meghna.bajoria
 * @since 22/02/21 2:49 PM
 **/
@RestController
public class UserController {

    @Autowired
    private SearchService searchService;

    @PostMapping(path = "/search")
    public MyResponseDTO updateEmployee(@RequestBody MyRequestDTO request) {

        return searchService.searchCompany(request);
    }
}
