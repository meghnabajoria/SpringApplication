package com.example.SessionOne.dto;

import java.util.List;

/**
 * @author meghna.bajoria
 * @since 22/02/21 2:50 PM
 **/
public class MyResponseDTO {

    private List<ProductDTO> products;
    private List<ProductDTO> locationBasedProducts;

    public List<ProductDTO> getLocationBasedProducts() {
        return locationBasedProducts;
    }

    public void setLocationBasedProducts(List<ProductDTO> locationBasedProducts) {
        this.locationBasedProducts = locationBasedProducts;
    }


    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }



}
