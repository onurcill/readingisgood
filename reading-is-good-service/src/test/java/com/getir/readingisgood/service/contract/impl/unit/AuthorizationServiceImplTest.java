package com.getir.readingisgood.service.contract.impl.unit;

import com.getir.readingisgood.service.contract.impl.AuthorizationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author onurc
 * @create 6/12/2021 5:24 PM
 */
@PropertySource("classpath:application-test.properties ")
public class AuthorizationServiceImplTest {

    @InjectMocks
    AuthorizationServiceImpl authorizationServiceImpl;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = NullPointerException.class)
    public void testGetJWTToken() throws Exception {
        String result = authorizationServiceImpl.getJWTToken("username@mail.com");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}