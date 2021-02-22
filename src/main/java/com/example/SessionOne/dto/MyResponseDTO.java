package com.example.SessionOne.dto;

import java.util.List;

/**
 * @author meghna.bajoria
 * @since 22/02/21 2:50 PM
 **/
public class MyResponseDTO {

    private List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }



}
