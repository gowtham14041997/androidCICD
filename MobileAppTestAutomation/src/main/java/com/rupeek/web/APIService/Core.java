package com.rupeek.web.APIService;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rupeek.web.service.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static base.BaseTest.getEnvironmentProperty;
import static org.testng.AssertJUnit.assertTrue;

public class Core {
    private static final Logger LOGGER = LogManager.getLogger(Core.class);
    public static String AUTHORIZATION = "Authorization";
    public static String CONTENT_TYPE = "Content-type";
    public static String APPLICATION_JSON = "application/json";
    private String token;
    private RestClient restClient;

    private static Core core;

    public static Core getInstance(){
        if(core == null){
            core =  new Core(
                    getEnvironmentProperty("core_baseurl"),
                    getEnvironmentProperty("core_auth")
            );
        }
        return core;
    }

    private Core(String baseUrl, String token) {
        this.token = token;
        restClient = new RestClient(baseUrl);
    }

    public void createLoan(long time,String url,String phone,boolean loanType) throws IOException, IOException {
        RestAssured.baseURI = url;
        RequestSpecification request= RestAssured.given();
        request.headers(CONTENT_TYPE,"Application/json");
        request.header(AUTHORIZATION,token);
        String requestJSON = new String(Files.readAllBytes(Paths.get("src/test/resources/Core/Loan.json")));
        requestJSON=requestJSON.replace("{{phone}}",phone);
        JsonObject jsonObject = new Gson().fromJson(requestJSON.toString(), JsonObject.class);
        jsonObject.addProperty("istakeover",loanType);
        jsonObject.addProperty("timeslotstart",time);
        jsonObject.addProperty("timeslotend",time+200);
        request.body(jsonObject.toString());
        Response response = request.post("/coreproxy/api/v2/support/createsupportqueue");
        assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
    }
}
