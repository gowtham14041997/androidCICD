package com.rupeek.web.db;

import database.sql.PostgreSQLDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

import static base.BaseTest.getEnvironmentProperty;

public class AndromedaDB {
    private String url;
    private String userName;
    private String password;
    private String status;
    private String loanId;
    private static PostgreSQLDB connection;
    Logger logger = LogManager.getLogger(AndromedaDB.class);

    private static AndromedaDB andromeda;
    //SchemeSlab schemeSlab = SchemeSlab.getInstance();

    private AndromedaDB(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
        connection = new PostgreSQLDB(this.url, this.userName, this.password);
    }

    private PostgreSQLDB getConnection(){
        return connection;
    }
    public static AndromedaDB getInstance() {
        if (andromeda == null) {
            andromeda = new AndromedaDB(
                    getEnvironmentProperty("postgres_Andromeda_URL"),
                    getEnvironmentProperty("postgres_Andromeda_username"),
                    getEnvironmentProperty("postgres_Andromeda_password")
            );
        }
        return andromeda;
    }
    public void updateStatus(String loanRequestId) throws SQLException {
        String query = String.format("SELECT * from loan_documents where core_loanrequest_id ='%s'",loanRequestId);
        ResultSet resultSet = connection.executeQuery(query);
        String id="";
        if (resultSet.next()){
            id = resultSet.getString("id");
        }
        connection.executeQuery(String.format("UPDATE loan_documents SET status='APPROVED' where core_loanrequest_id ='%s'",loanRequestId));
        String query1= String.format("UPDATE esign_requests SET status='SUCCESS' where loan_documents_id ='%s'",id);
        connection.executeQuery(query1);
    }
}
