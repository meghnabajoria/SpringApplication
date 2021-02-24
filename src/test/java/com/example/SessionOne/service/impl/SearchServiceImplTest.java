package com.example.SessionOne.service.impl;

import com.example.SessionOne.client.SearchClient;
import com.example.SessionOne.dto.MyRequestDTO;
import com.example.SessionOne.dto.MyResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author meghna.bajoria
 * @since 24/02/21 3:46 PM
 **/
@RunWith(MockitoJUnitRunner.class)
class SearchServiceImplTest {
    @InjectMocks
    private SearchServiceImpl searchService;

    @Mock
    private SearchClient searchClient;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown(){

    }

    @Test
    void searchCompany() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String,Object> searchTermMockObject = objectMapper.readValue(new URL("file:src/main/resources/search.mock"),Map.class);

        Map<String,Object> locationTermMockObject = objectMapper.readValue(
                new URL("file:src/main/resources/location.mock"),Map.class);

        Mockito.when(searchClient.getProducts("samsung")).thenReturn(searchTermMockObject);
        Mockito.when(searchClient.getProducts("stockLocation:\"jakarta\"")).thenReturn(locationTermMockObject);


        MyRequestDTO requestDTO = new MyRequestDTO();
        requestDTO.setSearchTerm("samsung");
        requestDTO.setLocation("jakarta");
        MyResponseDTO responseDTO = searchService.searchCompany(requestDTO);

        assertEquals(responseDTO.getProducts().size(),10);
        assertEquals(responseDTO.getLocationBasedProducts().size(),10);

        //Mockito.verify(searchClient,Mockito.times(2)).getProducts("samsung");


    }

    @Test
    public void testGetProductsExceptionTest() throws IOException{

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String,Object> searchTermMockObject = objectMapper.readValue(new URL("file:src/main/resources/search.mock"),Map.class);

        //Map<String,Object> locationTermMockObject = objectMapper.readValue(
          //      new URL("file:src/main/resources/location.mock"),Map.class);

        Mockito.when(searchClient.getProducts("samsung")).thenReturn(searchTermMockObject);
        Mockito.when(searchClient.getProducts("stockLocation:\"jakarta\"")).thenThrow(NullPointerException.class);


        MyRequestDTO requestDTO = new MyRequestDTO();
        requestDTO.setSearchTerm("samsung");
        requestDTO.setLocation("jakarta");
        MyResponseDTO responseDTO = searchService.searchCompany(requestDTO);

        assertEquals(responseDTO.getProducts().size(),10);
        assertEquals(responseDTO.getLocationBasedProducts(),null);

    }


}