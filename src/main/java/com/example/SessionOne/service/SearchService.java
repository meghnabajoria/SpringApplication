package com.example.SessionOne.service;

import com.example.SessionOne.dto.MyRequestDTO;
import com.example.SessionOne.dto.MyResponseDTO;

/**
 * @author meghna.bajoria
 * @since 22/02/21 2:51 PM
 **/
public interface SearchService {
    public MyResponseDTO searchCompany(MyRequestDTO request);
}
