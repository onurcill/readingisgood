package com.getir.readingisgood.rest.contract.impl.unit;

import com.getir.readingisgood.rest.contract.impl.AuthControllerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

/**
 * @Author onurc
 * @create 6/12/2021 3:03 PM
 */
public class AuthControllerImplTest {

    @InjectMocks
    AuthControllerImpl authControllerImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin() throws Exception {
        ResponseEntity<String> result = authControllerImpl.login("email", "pwd");
        Assert.assertNotNull(result);
    }
}