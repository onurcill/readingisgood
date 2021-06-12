package com.getir.readingisgood.rest.contract.impl.integration;

import com.getir.readingisgood.rest.model.BookCreateRequest;
import com.getir.readingisgood.rest.model.CustomerRequest;
import com.getir.readingisgood.rest.model.CustomerResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @Author onurc
 * @create 6/12/2021 4:07 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testAddEmployee() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("email", "first.last@example.com");
        map.add("password","123");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);


        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/api/v1/authorization",request, String.class);
        assertEquals(302, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testCreateBook() {
        BookCreateRequest book = new BookCreateRequest();
        book.setDescription("test");
        book.setName("firstbook");
        book.setUnitPrice(BigDecimal.valueOf(100.0));
        book.setUnitsInStock(100);

        ResponseEntity<?> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/v1/books", book, BookCreateRequest.class);
        assertNotNull(postResponse);
        assertEquals(401,postResponse.getStatusCodeValue());
    }

    @Test
    public void testCreateCustomer() {
        CustomerRequest newCustomer = new CustomerRequest();
        newCustomer.setEmail("test@test.com");
        newCustomer.setPhone("123456789");
        newCustomer.setFirstName("test");
        newCustomer.setLastName("test");

        ResponseEntity<CustomerResponse> postResponse =  restTemplate.postForEntity("http://localhost:" + port + "/api/v1/customers", newCustomer, CustomerResponse.class);
        assertNotNull(postResponse);
        assertEquals(401,postResponse.getStatusCodeValue());
    }
}
