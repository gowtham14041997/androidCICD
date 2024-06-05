package com.rupeek.web.service;

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
import com.jayway.jsonpath.JsonPath;
import com.rupeek.web.service.RESTApi;
import com.rupeek.web.service.RestClient;
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

public class ActiveLoans {
    private static final Logger LOGGER = LogManager.getLogger(com.rupeek.web.service.ActiveLoans.class);
    public static String AUTHORIZATION = "Authorization";
    public static String CONTENT_TYPE = "content-type";
    public static String APPLICATION_JSON = "application/json";
    private String token;
    private RestClient restClient;

    private static ActiveLoans activeLoans;

    public static ActiveLoans getInstance(){
        if(activeLoans == null){
            activeLoans =  new ActiveLoans(
                    getEnvironmentProperty("rupeek.web"),
                    getEnvironmentProperty("rupeek.web.authtoken")
            );
        }
        return activeLoans;
    }

    private ActiveLoans(String baseUrl, String token) {
        this.token = token;
        restClient = new RestClient(baseUrl);
    }

    public JSONArray activeLoan(String date)  {
        Map<String, String> headers = new HashMap<>();
        headers.put(AUTHORIZATION, this.token);
        headers.put(CONTENT_TYPE,APPLICATION_JSON);
        Response response = restClient.whenGetRequestIsInvoked(
                RESTApi.Resource.FETCH_GOLD_PRICE, headers, null, null, date);
        String responseAsString = response.body().asString();
        System.out.println("response"+responseAsString.toString());
        assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
        JSONObject jsonResponse = new JSONObject(responseAsString);
        LOGGER.info("gold Prices response: " + jsonResponse);
        JSONArray goldPrices = jsonResponse.getJSONObject("data").getJSONArray("goldPrices");
        return goldPrices;
    }

}