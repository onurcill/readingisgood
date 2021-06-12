package com.getir.readingisgood.rest.contract.impl.unit;

import com.getir.readingisgood.rest.contract.impl.AuthControllerImpl;
import com.getir.readingisgood.rest.model.GenericResponse;
import com.getir.readingisgood.service.contract.AuthorizationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

/**
 * @Author onurc
 * @create 6/12/2021 3:03 PM
 */
public class AuthControllerImplTest {

    @Mock
    AuthorizationService authorizationService;

    @InjectMocks
    AuthControllerImpl authControllerImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin() throws Exception {
        when(authorizationService.getJWTToken("email")).thenReturn("token");
        ResponseEntity<GenericResponse> result = authControllerImpl.login("email", "pwd");
        Assert.assertNotNull(result);
    }
}