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
 * API tests for ContactApi
 */
public class ContactApiTest {

    private ContactApi api;

    @Before
    public void setup() {
        api = new ApiClient().buildClient(ContactApi.class);
    }

    
    /**
     * Deletes a contact
     *
     * 
     */
    @Test
    public void getUserRolesTest() {
        Long userId = null;
        Long restrictId = null;
        // List<Role> response = api.getUserRoles(userId, restrictId);

        // TODO: test validations
    }

    
}
