package com.rupeek.web.db;

import database.sql.MySQLDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static base.BaseTest.getEnvironmentProperty;

    public final class CustomerIdentityServiceDB {
        private String url;
        private String userName;
        private String password;
        private Connection connection;
        static Logger logger = LogManager.getLogger(CustomerIdentityServiceDB.class);
        private static CustomerIdentityServiceDB customerIdentityServiceDB;

        private CustomerIdentityServiceDB(String url, String userName, String password) {
            this.url = url;
            this.userName = userName;
            this.password = password;
        }


        public static CustomerIdentityServiceDB getInstance(){

            if(customerIdentityServiceDB == null){
                customerIdentityServiceDB = new CustomerIdentityServiceDB(
                        getEnvironmentProperty("mysqlcis_url"),
                        getEnvironmentProperty("mysqlcis_username"),
                        getEnvironmentProperty("mysqlcis_password")
                );
            }
            return customerIdentityServiceDB;
        }

        private Connection getConnection(){
            try {
                if(connection == null || connection.isClosed()){
                    try {
                        Class.forName("org.postgresql.Driver");
                        connection = DriverManager.getConnection(url, userName, password);
                        logger.info("The PostgreSQL connection is established!");
                    } catch (Exception var2) {
                        logger.error("The PostgreSQL connection could not be established");
                        var2.printStackTrace();
                    }
                }
            }catch (SQLException sqlException){
                logger.error("Error occured while connecting to db :" + sqlException.getMessage());
            }
            return connection;

        }

        public boolean IsExistingUser(String phoneNumber) throws SQLException{
            if(connection==null){
                logger.info("connection is null");
            }
            Integer matchedRecordCount = 0;
            try {
                Statement smt = getConnection().createStatement();
                ResultSet resultSet = smt.executeQuery(String.format("select count(*) from leads where primary_phone_number='%s'", phoneNumber));
                if(resultSet.next()){
                    matchedRecordCount = resultSet.getInt(1);
                }
                return matchedRecordCount>0 ? true : false;
            }
            catch (Exception e){
                System.out.println("DB connection error");
            }
            return false;
        }

        public void deleteAddress(String leadId) {

            String queryString = "DELETE from address" + String.format(" where lead_id='%s'", leadId);
            int resultAsJson;
            try {
                Statement smt = getConnection().createStatement();
                resultAsJson = smt.executeUpdate(queryString);
            } catch (Exception e) {
                logger.error("Could not delete address");
            }


        }

        public String getLead(String phone) {

            String queryString = String.format("select * from leads where primary_phone_number='%s'", phone);
            ResultSet resultAsJson;
            String lead="";
            try {
                Statement smt = getConnection().createStatement();
                resultAsJson = smt.executeQuery(queryString);
                while (resultAsJson.next()) {
                    lead= resultAsJson.getString("lead_id");
                }
            } catch (Exception e) {
                logger.error("Could not find lead");
            }

          return lead;
        }



        public static void main(String[] args) throws SQLException {

            CustomerIdentityServiceDB connection = new CustomerIdentityServiceDB(
                    "jdbc:mysql://channelcast-beta.cgmpejvbbeww.ap-south-1.rds.amazonaws.com/lead_capture_qa",
                    "las-user",
                    "G76u3GLj");

        }
    }


