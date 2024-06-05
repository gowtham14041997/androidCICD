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

public class FetchLoanDetails {
    private static final Logger LOGGER = LogManager.getLogger(com.rupeek.web.service.FetchLoanDetails.class);
    public static String AUTHORIZATION = "Authorization";
    public static String CONTENT_TYPE = "content-type";
    public static String APPLICATION_JSON = "application/json";
    private String token;
    private RestClient restClient;
    private static FetchLoanDetails fetchLoanDetails;

    private FetchLoanDetails(String baseUrl, String token) {
        this.token = token;
        restClient = new RestClient(baseUrl);
    }

    public static FetchLoanDetails getInstance(){
        if(fetchLoanDetails == null){
            fetchLoanDetails =  new FetchLoanDetails(
                    getEnvironmentProperty("rpkweb"),
                    getEnvironmentProperty("rpkweb.token")
            );
        }
        return fetchLoanDetails;
    }
    public JSONArray fetchLoanDetails()  {
        Map<String, String> headers = new HashMap<>();
        headers.put(AUTHORIZATION, this.token);
        headers.put(CONTENT_TYPE,APPLICATION_JSON);
        Response response = restClient.whenGetRequestIsInvoked(
                RESTApi.Resource.FETCH_LOAN_DETAILS, headers, null, null);
        String responseAsString = response.body().asString();
        assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
        JSONObject jsonResponse = new JSONObject(responseAsString);
        LOGGER.info("gold Loan Details " + jsonResponse);
        JSONArray goldLoanDetails = jsonResponse.getJSONObject("data").getJSONArray("custloans");
        return goldLoanDetails;
    }

}