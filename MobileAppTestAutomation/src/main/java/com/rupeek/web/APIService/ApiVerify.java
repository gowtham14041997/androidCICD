package com.rupeek.web.APIService;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import com.rupeek.web.db.CoreDB;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.bson.Document;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base.BaseTest.getEnvironmentProperty;

public class ApiVerify {
    public static String getSchemeOtp(String phone,String url) {
        String agentId = CoreDB.getInstance().getUserIdByPhone(phone);
        String userId= CoreDB.getInstance().getUserIdFromLoanRequest(agentId);
        RestAssured.baseURI = url;
        RequestSpecification request=RestAssured.given();
        String authorization = getEnvironmentProperty("LA_Authtoken");
        request.header("Authorization",authorization);

        request.queryParam("customerid",userId);
        request.queryParam("process","disbursement");
        Response response = request.get("/api/v1/otp/");
        JsonObject body = new Gson().fromJson(response.body().asString(), JsonObject.class);
        String otp = body.get("otp").getAsString();
        return otp;
    }


    public static String getNotification(String phone,String url,String loanType) {
        String agentId = CoreDB.getInstance().getUserIdByPhone(phone);
        String userId= CoreDB.getInstance().getUserIdFromLoanRequest(agentId);
        Document loanRequest=CoreDB.getInstance().getLoanRequest(phone);
        String requestId = loanRequest.get("_id").toString();
        LocalDate currentDate = LocalDate.now();
        LocalDateTime start = currentDate.atStartOfDay();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String startOfDay = start.format(formatter);
        LocalDateTime endOfDay = currentDate.atTime(23, 59, 59);
        String endOfDayString = endOfDay.atOffset(ZoneOffset.UTC).toString();
        RestAssured.baseURI = url;
        RequestSpecification request=RestAssured.given();
        String authorization = getEnvironmentProperty("LA_Authtoken");
        request.header("Authorization",authorization);
        String response = request.get("/api/v1/notifications?filterType=KYC&status=PENDING&city=ALL&fromDate="+startOfDay+"&toDate="+endOfDayString).body().asString();
        List<String> notificationId = JsonPath.read(response, String.format("$.notificationResponse[?(@.eventType=='KYC UPLOAD' && @.loanRequestId=='%s' )]._id",requestId));
        return notificationId.get(0).toString();

    }

    public static String createVan(String phone,String url) {
        String agentId = CoreDB.getInstance().getUserIdByPhone(phone);
        Document loan=CoreDB.getInstance().getLoanRequest(phone);
        String refId = loan.get("referencenumber").toString();
        String userId= CoreDB.getInstance().getUserIdFromLoanRequest(agentId);
        Document accountDetails = CoreDB.getInstance().getCustomerProfile(userId);
        String ifsc = accountDetails.get("ifsc").toString();
        String accountNumber = accountDetails.get("accountnumber").toString();
        String beneficiary = accountDetails.get("beneficiary").toString();
        RestAssured.baseURI = url;
        RequestSpecification request=RestAssured.given();
        String authorization = getEnvironmentProperty("LA_Authtoken");
        request.header("Authorization",authorization);
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("account",accountNumber);
        requestBody.addProperty("ifsc",ifsc);
        requestBody.addProperty("beneficiary",beneficiary);
        request.body(requestBody.toString());
        Response response = request.get("/api/techsupport/van/"+refId);
        JsonObject body = new Gson().fromJson(response.body().asString(), JsonObject.class);
        String otp = body.get("otp").getAsString();
        return otp;
    }

    public static boolean approveEsign(String phone,String url, String loanType) throws IOException {

        String notificationId = getNotification(phone,url,loanType);
        String agentId = CoreDB.getInstance().getUserIdByPhone(phone);
        String userId= CoreDB.getInstance().getUserIdFromLoanRequest(agentId);
        //Document document=CoreDB.getInstance().getCustomerProfile(userId);
        Document loanRequest=CoreDB.getInstance().getLoanRequest(phone);
        String requestId = loanRequest.get("_id").toString();
        String birthDate= LocalDate.now().toString();
        String dob= birthDate+"T00:00:00.000Z";
        SimpleDateFormat originalDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat desiredDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate="";
        try {
            Date originalDate = originalDateFormat.parse(birthDate);
            formattedDate=desiredDateFormat.format(originalDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String file = "LoanAdmin" + File.separator + "Esign.json";
        String esignBody= FileResourceUtil.readFileAsString(file);
        String requestBody=esignBody.replace("{{userId}}",userId).
                replace("{{dob}}",dob).
                replace("{{formatDob}}",formattedDate).
                replace("{{agentId}}",agentId).
                replace("{{requestId}}",requestId);
        JsonObject body = new Gson().fromJson(requestBody, JsonObject.class);
        RestAssured.baseURI = url;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        String authorization = getEnvironmentProperty("LA_Authtoken");
        request.header("Authorization",authorization);
        request.body(body.toString());
        Response response = request.post("/api/v1/actions/kyc/"+notificationId);
        System.out.println("Response"+response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200);
        return true;
    }



    public static void main(String[] args) {
        //System.out.println(ApiVerify.getNotification("8249631728","jfgh"));
    }





}
