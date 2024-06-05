package com.rupeek.web.service;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rupeek.web.service.RESTApi;
import com.rupeek.web.service.RestClient;
import com.rupeek.web.db.CoreDB;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static base.BaseTest.getEnvironmentProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountService {
    private static final Logger LOGGER = LogManager.getLogger(com.rupeek.web.service.AccountService.class);
    public static String AUTHORIZATION = "Authorization";
    public static String CONTENT_TYPE = "Content-type";
    public static String APPLICATION_JSON = "application/json";
    private String token;
    private RestClient restClient;

    private static AccountService accountService;

    public static AccountService getInstance(){
        if(accountService == null){
            accountService =  new AccountService(
                    getEnvironmentProperty("accountService_baseurl")

            );
        }
        return accountService;
    }

    private AccountService(String baseUrl) {
        restClient = new RestClient(baseUrl);
    }


    public void createLoan(int days) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put(AUTHORIZATION, this.token);
        headers.put(CONTENT_TYPE,APPLICATION_JSON);
        String requestJSON = new String(Files.readAllBytes(Paths.get("src/test/resources/AccountService/loanRequest.json")));
        requestJSON=sanctionedBeforeXDaysAndRequestBodyIsSet(days, requestJSON);
        JsonObject jsonObject = new Gson().fromJson(requestJSON,JsonObject.class);
        Response response = restClient.whenPostRequestIsInvoked(RESTApi.Resource.CREATE_LOAN, headers,  jsonObject.toString());
        assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
    }

    public void deleteLoan() throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put(AUTHORIZATION, this.token);
        headers.put(CONTENT_TYPE,APPLICATION_JSON);
        /*Map<String, String> requestBody = new HashMap<>();
        requestBody.put("qa","true");
        requestBody.put("requester","658143ea499e995a2af63119");
        requestBody.put("loanof","7054");*/
        String requestJSON = new String(Files.readAllBytes(Paths.get("src/test/resources/AccountService/deleteLoan.json")));
        JsonObject jsonObject = new Gson().fromJson(requestJSON,JsonObject.class);
        Response response = restClient.whenDeleteRequestIsInvoked(RESTApi.Resource.DELETE_LOAN,headers,jsonObject.toString());
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }

    public String sanctionedBeforeXDaysAndRequestBodyIsSet(int days, String requestJSON){
        LocalDate loanStartedDate = LocalDate.now().minusDays(days);
        //requestJSON = requestJSON.replace("{{loanstartedon}}", loanStartedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return requestJSON;
    }
}