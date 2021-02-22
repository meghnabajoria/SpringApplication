package com.example.SessionOne.service.impl;

import com.example.SessionOne.dto.MyRequestDTO;
import com.example.SessionOne.dto.MyResponseDTO;
import com.example.SessionOne.dto.ProductDTO;
import com.example.SessionOne.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author meghna.bajoria
 * @since 22/02/21 2:51 PM
 **/

@Service
public class SearchServiceImpl implements SearchService {



    @Override
    public MyResponseDTO searchCompany(MyRequestDTO request) {
            //process
            MyResponseDTO responseDTO =  new MyResponseDTO();
            ProductDTO product =  new ProductDTO();
            product.setDescription("samsung galaxy s5.....");
            product.setTitle("samsung galaxy s5");
            product.setInStock(true);
            responseDTO.setProducts(Arrays.asList(product));
            return responseDTO;
    }
}
