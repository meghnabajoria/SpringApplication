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
           // String searchTerm =  request.getSearchTerm();
            //String location = request.getLocation();

            Map<String, Object> products = searchClient.getProducts(request.getSearchTerm());
            Map<String, Object> location = searchClient.getProducts(("q=stockLocation:"+request.getLocation()));

            List<Map<String, Object>> productObjectList = (List<Map<String, Object>>) ((Map) products.get("response")).get("docs");
            List<Map<String, Object>> productLocationList = (List<Map<String, Object>>) ((Map) location.get("response")).get("docs");

            List<ProductDTO> list = new ArrayList<>();
            List<ProductDTO> list2 = new ArrayList<>();

            MyResponseDTO responseDTO =  new MyResponseDTO();

            for(int i=0;i<productObjectList.size();i++)
            {
                ProductDTO product =  new ProductDTO();
                String brandName = productObjectList.get(i).get("name").toString();
                String brandDesc = productObjectList.get(i).get("description").toString();
                int brandPrice = ((Double) productObjectList.get(i).get("salePrice")).intValue();
                boolean inStock = (int) productObjectList.get(i).get("isInStock") == 1? true:false;

                product.setDescription(brandDesc);
                product.setTitle(brandName);
                product.setInStock(inStock);
                product.setSalePrice(brandPrice);
                list.add(product);
            }


            for(int i=0;i<productLocationList.size();i++)
            {
                ProductDTO product =  new ProductDTO();
                String brandName = productLocationList.get(i).get("name").toString();
                String brandDesc = productLocationList.get(i).get("description").toString();
                int brandPrice = ((Double) productLocationList.get(i).get("salePrice")).intValue();
                boolean inStock = (int) productLocationList.get(i).get("isInStock") == 1? true:false;

                product.setDescription(brandDesc);
                product.setTitle(brandName);
                product.setInStock(inStock);
                product.setSalePrice(brandPrice);
                list2.add(product);
            }


            responseDTO.setProducts(list);
            responseDTO.setLocationBasedProducts(list2);

            return responseDTO;
    }
}
