package com.athanprodcasterAuthorizationServiceApiClient.apiPackage;

import com.athanprodcasterAuthorizationServiceApiClient.ApiClient;
import com.athanprodcasterAuthorizationServiceApiClient.Models.Role;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TestControllerApi
 */
public class TestControllerApiTest {

    private TestControllerApi api;

    @Before
    public void setup() {
        api = new ApiClient().buildClient(TestControllerApi.class);
    }

    
    /**
     * 
     *
     * 
     */
    @Test
    public void getUserRolesTestTest() {
        Long userId = null;
        Long restrictId = null;
        // List<Role> response = api.getUserRolesTest(userId, restrictId);

        // TODO: test validations
    }

    
}
