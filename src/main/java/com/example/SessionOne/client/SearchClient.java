package com.example.SessionOne.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Objects;

/**
 * @author meghna.bajoria
 * @since 22/02/21 4:18 PM
 **/

@FeignClient(name = "search-client", url = "10.177.68.40:8983")
public interface SearchClient {

    //API Ref [GET] 10.177.68.40:8983/solr/productCollection/browse?q=samsung

    @RequestMapping(method = RequestMethod.GET, path = "/solr/productCollection/select")
    Map<String, Object> getProducts(@RequestParam("q") String query);
}
