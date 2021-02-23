package com.example.SessionOne.dto;

/**
 * @author meghna.bajoria
 * @since 22/02/21 3:00 PM
 **/
public class MyRequestDTO {
    private String searchTerm;
    private String Location;

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }


    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
}
