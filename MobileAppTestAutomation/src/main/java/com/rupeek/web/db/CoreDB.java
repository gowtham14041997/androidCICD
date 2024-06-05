package com.rupeek.web.db;
import base.BaseTest;
import database.MongoDB;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


enum CoreDBCollection {
    USER("user"),
    CUSTOMER_PROFILE("customerprofile"),
    LOAN_REQUEST("loanrequest");
    private String collectionName;

    CoreDBCollection(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return this.collectionName;
    }
}

public final class CoreDB extends BaseTest {
    private static String connectionString;
    private static String dbName;
    private static MongoDB coreMongoDB;
    private static CoreDB coreDB;
    private static final Logger LOGGER = LogManager.getLogger(CoreDB.class);

    public static CoreDB getInstance() {
        if (coreDB == null) {
            coreDB = new CoreDB(
                    getEnvironmentProperty("mongoDB.core.connectionString"),
                    getEnvironmentProperty("mongoDB.core.database")
            );
        }
        return coreDB;
    }

    private CoreDB(String connectionString, String dbName) {
        this.connectionString = connectionString;
        this.dbName = dbName;
        coreMongoDB = new MongoDB(connectionString, dbName);
    }

    public String getCoreUserByPhoneNumber(String phoneNumber) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("phone", phoneNumber);
        Document document = coreMongoDB.getDocuments(
                CoreDBCollection.USER.getCollectionName(),
                filter).get(0);
        System.out.println(document.toString());
//        HashMap x = new HashMap();
//        JSONObject obj = (JSONObject) JSON.parse(document.toString().substring(9,document.toString().length()));
        return document.get("phonevertoken").toString();
    }

    public String getUserIdByPhone(String phone){
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("phone", phone);
        Document document = coreMongoDB.getDocuments(CoreDBCollection.USER.getCollectionName(), filter).get(0);
        String userId = document.get("_id").toString();
        return userId;
    }

    public String getTransactionId(String userId){
        try {
            HashMap<String, Object> filter = new HashMap<>();
            filter.put("requester", new ObjectId(userId));
            HashMap<String, Integer> sort = new HashMap<>();
            sort.put("createdAt", -1);
            Document document = coreMongoDB.getSortedDocuments(CoreDBCollection.LOAN_REQUEST.getCollectionName(), filter, sort).get(0);
            String transactionId = document.get("_id").toString();
            return transactionId;
        }catch (Exception e){
            LOGGER.info("Transaction doesn't exist in DB");
        }
        return null;
    }
    public long deleteDocumentByPhone(String phone){
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("phone",phone);
        long deletedCount = coreMongoDB.deleteDocuments(CoreDBCollection.USER.getCollectionName(), filter);
        return deletedCount;
    }

    public int getNumberOfUserByNumber(String phone){
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("phone",phone);
        int size = coreMongoDB.getDocuments(CoreDBCollection.USER.getCollectionName(),filter).size();
        return size;
    }

    public void archiveLoanRequest(String id){
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("_id", new ObjectId(id));
        HashMap<String, Object> updatedStatusCode = new HashMap<>();
        updatedStatusCode.put("statuscode", 9);
        coreMongoDB.updateDocuments(CoreDBCollection.LOAN_REQUEST.getCollectionName(), filter,
                updatedStatusCode);

    }

    public String getOtpFromLoanRequest(String agentId) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("assignedagent", new ObjectId(agentId));
        HashMap<String, Integer> sort = new HashMap<>();
        sort.put("createdAt",Integer.valueOf(-1));
        Document document = coreMongoDB.getSortedDocuments(
                CoreDBCollection.LOAN_REQUEST.getCollectionName(),
                filter,sort).get(0);
        return document.get("agentvercode").toString();
    }

    public String getUserIdFromLoanRequest(String agentId) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("assignedagent", new ObjectId(agentId));
        HashMap<String, Integer> sort = new HashMap<>();
        sort.put("createdAt",Integer.valueOf(-1));
        Document document = coreMongoDB.getSortedDocuments(
                CoreDBCollection.LOAN_REQUEST.getCollectionName(),
                filter,sort).get(0);
        return document.get("requester").toString();
    }
    public Document getUserFromPhone(String phone) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("phone",phone);
        Document document = coreMongoDB.getDocuments(
                CoreDBCollection.USER.getCollectionName(),
                filter).get(0);

        return document;
    }
    public Document getLoanRequest(String phone) {
        String agentId = getUserIdByPhone(phone);
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("assignedagent", new ObjectId(agentId));
        Document document = coreMongoDB.getDocuments(
                CoreDBCollection.LOAN_REQUEST.getCollectionName(),
                filter).get(0);
        return document;
    }
    public void deleteCustomerProfile(String account) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("accountnumber", account);
        coreMongoDB.deleteDocuments(
                CoreDBCollection.CUSTOMER_PROFILE.getCollectionName(),
                filter);
    }

    public Document getCustomerProfile(String userId) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("user", new ObjectId(userId));
        Document customerProfile = coreMongoDB.getDocuments(
                CoreDBCollection.CUSTOMER_PROFILE.getCollectionName(),
                filter).get(0);
        return customerProfile;

    }

    public boolean updateStatus(String phone) {
        String userId= getUserIdByPhone(phone);
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("assignedagent", new ObjectId(userId));
        HashMap<String, Object> update = new HashMap<>();
        update.put("statuscode",2.7);
        coreMongoDB.updateDocuments(
                CoreDBCollection.LOAN_REQUEST.getCollectionName(),
                filter,update);
        String statuscode =  coreMongoDB.getDocuments(
                CoreDBCollection.LOAN_REQUEST.getCollectionName(),
                filter).get(0).get("statuscode").toString();
        if(Double.valueOf(statuscode)==2.7){
            return true;
        }
        return false;

    }
    public String getPhoneFromUser(String userId) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("_id",new ObjectId(userId));
        Document document = coreMongoDB.getDocuments(
                CoreDBCollection.USER.getCollectionName(),
                filter).get(0);

        return document.get("phone").toString();
    }
    public Boolean isExistingUser(String phoneNumber) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("phone", phoneNumber);
        List<Document> documents = coreMongoDB.getDocuments(
                CoreDBCollection.USER.getCollectionName(),
                filter);
        if (documents != null && documents.size() >= 1) {
            return true;
        }
        return false;
    }
    public Boolean hasActiveTransaction(String phoneNumber) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("phone", phoneNumber);
        if(isExistingUser(phoneNumber)) {
            Document document = coreMongoDB.getDocuments(
                    CoreDBCollection.USER.getCollectionName(),
                    filter).get(0);
            String userId = document.get("_id").toString();
            filter.remove("phone", phoneNumber);
            filter.put("requester", new ObjectId(userId));
            List<Document> documents = coreMongoDB.getDocuments(CoreDBCollection.LOAN_REQUEST.getCollectionName(), filter);
            for (Document userDocument : documents) {
                String statusCode = userDocument.get("statuscode").toString();
                if (Double.valueOf(statusCode) >= 1.4 || Double.valueOf(statusCode) <= 3.5) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> getActiveTransactions(String phoneNumber) {
        List<String> transactions= new ArrayList<>();
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("phone", phoneNumber);
        if(isExistingUser(phoneNumber)) {
            Document document = coreMongoDB.getDocuments(
                    CoreDBCollection.USER.getCollectionName(),
                    filter).get(0);
            String userId = document.get("_id").toString();
            filter.remove("phone", phoneNumber);
            filter.put("requester", new ObjectId(userId));
            List<Document> documents = coreMongoDB.getDocuments(CoreDBCollection.LOAN_REQUEST.getCollectionName(), filter);
            for (Document userDocument : documents) {
                String statusCode = userDocument.get("statuscode").toString();
                if (Double.valueOf(statusCode) >= 1.4 || Double.valueOf(statusCode) <= 3.5) {
                    transactions.add(userDocument.get("_id").toString());
                }
            }
        }
        return transactions;
    }

}