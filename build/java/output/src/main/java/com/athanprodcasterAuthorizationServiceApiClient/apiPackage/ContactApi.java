package com.athanprodcasterAuthorizationServiceApiClient.apiPackage;

import com.athanprodcasterAuthorizationServiceApiClient.ApiClient;
import com.athanprodcasterAuthorizationServiceApiClient.EncodingUtils;

import com.athanprodcasterAuthorizationServiceApiClient.Models.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-17T17:34:47.913+01:00[Europe/Berlin]")
public interface ContactApi extends ApiClient.Api {


  /**
   * Deletes a contact
   * 
   * @param userId  (required)
   * @param restrictId  (required)
   * @return List&lt;Role&gt;
   */
  @RequestLine("GET /tests/{userId}/{restrictId}")
  @Headers({
    "Accept: */*",
  })
  List<Role> getUserRoles(@Param("userId") Long userId, @Param("restrictId") Long restrictId);
}
