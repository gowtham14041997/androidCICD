package com.rupeek.web.pages;

import com.google.gson.Gson;
import com.rupeek.web.LocatorType;
import com.rupeek.web.locator.Locator;
import io.appium.java_client.AppiumDriver;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.*;

public class Common extends BasePage {

    private static final Logger logger = LogManager.getLogger(Common.class);
    Waits wait ;
    Swipes swipe = new Swipes(driver);

    public Common(AppiumDriver driver) {
        super(driver);
        this.wait = new Waits(driver);
    }

    public String getCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        logger.info("The current url is  - "+ currentUrl);
        return currentUrl;
    }


    public String getOtpFromAAARedis(String phone, String host, String port, String redisType) throws Throwable {
        System.out.println(port +"   "+ host);
        JedisPool jedisPool = new JedisPool(host, Integer.parseInt(port));
        Jedis jedis = jedisPool.getResource();
        JSONParser parser = new JSONParser();
        JSONObject json;
        if (redisType.equals("cw")) {
            json = (JSONObject) parser.parse(jedis.get("phone~" + phone));
        }
        else if(redisType.equals("customerApp")){
            String signUpOtp =  jedis.get("SIGN_UP_OTP_OTP_" + phone);
            logger.info("otp is :"+signUpOtp);
            return signUpOtp;
        }
        else{
            Jedis jed = new Jedis(host,Integer.parseInt(port));
            jed.select(2);
            String otp = jed.get(phone+"_otp");
            logger.info("otp is :"+otp);
            return otp;
        }
        Gson gson = new Gson();
        Map attributes = gson.fromJson(gson.toJson(json),Map.class);
        String otp = attributes.get("otp").toString().split("\\.")[0];
        logger.info("otp is :"+otp);
        return otp;
    }









}
