package com.blueyonder.shopservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
 
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.blueyonder.shopservice.entity.Category;
import com.blueyonder.shopservice.entity.Product;
 

 
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryControllerE2ETest {
    @Autowired
    private TestRestTemplate restTemplate;
    Integer id;
//    @Test
//    @Order(5)
//    public void testGetCategories_Success() {
//        String requestUrl = "/ecommerce/api/v1/category/all-category";
//        ResponseEntity<Set<Category>> responseEntity = restTemplate.exchange(
//            requestUrl,
//            HttpMethod.GET,
//            null,
//            new ParameterizedTypeReference<Set<Category>>() {}
//        );
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//    }
    @Test
    @Order(2)
    public void testGetCategories_ByName() {
        String requestUrl = "/ecommerce/api/v1/category/get-category-name?name=Fashion";
        ResponseEntity<Object> responseEntity = restTemplate.exchange(
            requestUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Object>() {}
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    @Test
    @Order(3)
    public void testGetCategories_ById() {
        String requestUrl = "/ecommerce/api/v1/category/get-category?id=1";
        ResponseEntity<Product> responseEntity = restTemplate.exchange(
            requestUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Product>() {}
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
  
//    @Test
//    @Order(1)
//    public void testAddCategory() {
//        String requestUrl = "/ecommerceapp/api/v1/category/addcategory";
//        
//        Category category = new Category();
//        category.setName("test");
//        category.setCategoryDescription("test");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<Category> requestEntity = new HttpEntity<>(category, headers);
//
//        ResponseEntity<Category> responseEntity = restTemplate.exchange(
//            requestUrl,
//            HttpMethod.POST,
//            requestEntity,
//            new ParameterizedTypeReference<Category>() {}
//        );
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//    }
    @Test
    @Order(6)
    public void testDeleteCategory() {
//    	System.out.println(Integer.toString(id));
        String requestUrl = "/ecommerce/api/v1/category/delete-category?id=1";
        ResponseEntity<String> responseEntity = restTemplate.exchange(
            requestUrl,
            HttpMethod.DELETE,
            null,
            new ParameterizedTypeReference<String>() {}
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}

