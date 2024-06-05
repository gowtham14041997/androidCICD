package com.rupeek.web.APIService;

import redis.clients.jedis.Jedis;

import static base.BaseTest.getEnvironmentProperty;

public class AAARedis {
    private static AAARedis aaaRedis;
    private String host;
    private Integer port;
    private static Jedis jedis;
    private AAARedis(String host, Integer port){
        this.host = host;
        this.port = port;
        jedis = new Jedis(host, port);
    }

    public static AAARedis getInstance(){
        if(aaaRedis == null || !jedis.isConnected()){
            aaaRedis = new AAARedis(
                    getEnvironmentProperty("aaa_redis_host"),
                    Integer.valueOf(getEnvironmentProperty("aaa_redis_port"))
            );
        }
        return aaaRedis;
    }

    public String getOtp(String email,String user){
        String key = "EMAIL_VERIFICATION_OTP_"+email+"_"+user;
        System.out.println("key:"+ key);
        return getValue(key);
    }

    private String getValue(String key){
        jedis.connect();
        //jedis.select(index);
        String value = jedis.get(key);
        jedis.disconnect();
        return value;
    }
}
