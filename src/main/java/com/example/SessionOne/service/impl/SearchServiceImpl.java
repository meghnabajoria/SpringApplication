package com.example.SessionOne.service.impl;

import com.example.SessionOne.client.SearchClient;
import com.example.SessionOne.dto.MyRequestDTO;
import com.example.SessionOne.dto.MyResponseDTO;
import com.example.SessionOne.dto.ProductDTO;
import com.example.SessionOne.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author meghna.bajoria
 * @since 22/02/21 2:51 PM
 **/

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchClient searchClient;


    @Override
    public MyResponseDTO searchCompany(MyRequestDTO request) {
            //process
            Map<String, Object> products = searchClient.getProducts(request.getSearchTerm());


            List<Map<String, Object>> productObjectList = (List<Map<String, Object>>) ((Map) products.get("response")).get("docs");
            //System.out.println(productObjectList);
            List<ProductDTO> list = new ArrayList<>();
            MyResponseDTO responseDTO =  new MyResponseDTO();

            for(int i=0;i<productObjectList.size();i++)
            {
                ProductDTO product =  new ProductDTO();
                String brandName = productObjectList.get(i).get("name").toString();
                System.out.println(brandName);

                product.setDescription("samsung galaxy s5.....");
                product.setTitle(brandName);
                product.setInStock(true);
                list.add(product);
            }
            responseDTO.setProducts(list);

            return responseDTO;
    }
}
