package com.example.SessionOne.dto;

/**
 * @author meghna.bajoria
 * @since 22/02/21 3:25 PM
 **/
public class ProductDTO {

    private boolean inStock;
    private int salePrice;
    private String description;
    private String title;

    @Override
    public String toString() {
        return "MyResponseDTO{" +
                "inStock=" + inStock +
                ", salePrice=" + salePrice +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
