package com.rupeek.web.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import com.rupeek.web.db.CoreDB;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static base.BaseTest.getEnvironmentProperty;
import static org.testng.Assert.assertTrue;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static base.BaseTest.getEnvironmentProperty;
import static org.testng.Assert.assertTrue;

public class Andromeda {
    private static final Logger LOGGER = LogManager.getLogger(Andromeda.class);
    public static String AUTHORIZATION = "Authorization";
    public static String CONTENT_TYPE = "content-type";
    public static String APPLICATION_JSON = "application/json";
    private String token;
    private RestClient restClient;
    private static Andromeda andromeda;

    private Andromeda(String baseUrl, String token) {
        this.token = token;
        restClient = new RestClient(baseUrl);
    }

    public static Andromeda getInstance(){
        if(andromeda == null){
            andromeda =  new Andromeda(
                    getEnvironmentProperty("Andromeda_URL"),
                    getEnvironmentProperty("Andromeda_Auth")
            );
        }
        return andromeda;
    }

    public String eSignStatus(String phone)  {
        Map<String, String> headers = new HashMap<>();
        headers.put(AUTHORIZATION, this.token);
        headers.put(CONTENT_TYPE,APPLICATION_JSON);
        String requestId = CoreDB.getInstance().getLoanRequest(phone).get("_id").toString();
        Response response = restClient.whenGetRequestIsInvoked(
                RESTApi.Resource.ESIGN_REQUEST, headers, null, null,requestId);
        String responseAsString = response.body().asString();
        assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
       // String status = JsonPath.read(responseAsString,String.format("$.data.status"));
        return responseAsString;
    }
    public String initiateESign(String phone)  {
        String agentId= CoreDB.getInstance().getUserIdByPhone(phone);
        String requestId = CoreDB.getInstance().getLoanRequest(phone).get("_id").toString();
        String userId = CoreDB.getInstance().getUserIdFromLoanRequest(agentId);
        String phoneNumber  = CoreDB.getInstance().getPhoneFromUser(userId);
        Map<String, String> headers = new HashMap<>();
        headers.put(AUTHORIZATION, this.token);
        headers.put(CONTENT_TYPE,APPLICATION_JSON);
        JsonObject customer= new JsonObject();
        customer.addProperty("firstName","Rojalin");
        customer.addProperty("id",userId);
        customer.addProperty("lastName","Das");
        customer.addProperty("phone",phoneNumber);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("customerDetails", customer);
        jsonObject.addProperty("documentType","FED_LOAN_DOCUMENT");
        jsonObject.addProperty("lenderSlug","federal");
        System.out.println(jsonObject.toString());
        String body = new Gson().toJson(jsonObject) ;
        Response response = restClient.whenPostRequestIsInvoked(
                RESTApi.Resource.ESIGN_REQUEST, headers, body, null,null,requestId);
        String responseAsString = response.body().asString();
        assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
        // String status = JsonPath.read(responseAsString,String.format("$.data.status"));
        return responseAsString;
    }
}
