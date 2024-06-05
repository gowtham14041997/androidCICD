package com.rupeek.web.service;

public interface RESTApi {

    enum ApiContext {

        API("/api"),
        LAS("/las"),
        CIS("/cis"),
        LAS_QA2("/las-qa2"),
        SCHEDULER("/scheduler") ;

        private final String apiContext;

        ApiContext(String apiContext) {
            this.apiContext = apiContext;
        }

        @Override
        public String toString() {
            return apiContext;
        }
    }


    enum Version {
        V1("/v1"),
        V2("/v2"),
        V3("/V3"),
        NONE("");
        private final String versionNo;

        Version(String verNo) {
            this.versionNo = verNo;
        }

        @Override
        public String toString() {
            return versionNo;
        }
    }

    enum Resource {

        CREATE_USER(ApiContext.API, "/v1/auth/createaccount"),
        AAA_SEND_OTP(ApiContext.API, "/v1/auth/sendotp"),
        AAA_OTP_LOGIN(ApiContext.API, "/v1/auth/otplogin"),
        UPDATE_USER_ROLE(ApiContext.API,"/hr/addRole"),

        //Pledge Card
        PLEDGE_CARD_V1( Version.V1, "/pledge-card"),
        PLEDGE_CARD_V2( Version.V2, "/pledge-card"),
        PLEDGE_CARD_UPLOAD( Version.V1, "/pledge-card/upload"),
        PLEDGE_CARD_SAVE( Version.V1, "/pledge-card/saveImages"),
        PLEDGE_CARD_APPROVAL( Version.V1, "/pledge-card/approve"),
        PLEDGE_CARD_REJECT( Version.V1, "/pledge-card/undigitized/{0}/reject"),
        PLEDGE_CARD_UPDATE_RELEASE_AMOUNT(Version.V1, "/pledge-card/update-release-amount"),
        PLEDGE_CARD_HO_APPROVAL( Version.V2, "/pledge-card/ho_approval"),
        PLEDGE_CARD_DIGITIZE(Version.V1,"/pledge-card/{0}"),
        PLEDGE_CARD_ATTACH_LOAN_APPLICATION(Version.V1,"/loan-application/{0}/attach-pledge-cards"),


        LENDER("/lender"),
        LENDER_SCHEME("/lender/{0}/scheme"),
        LENDER_BRANCH( Version.V1, "/lender/{0}/lender-branch"),
        LENDER_FETCH_SCHEME( Version.V1, "/lender/fetch-scheme"),
        LOAN_APPLICATION(Version.V1, "/loan-application/get-loan-applications"),
        LOAN_APPLICATION_BY_ID("/loan-application/{0}"),
        LOAN_REASON(Version.V1,"/loan-application/get-loan-reasons"),
        CREATE_LOAN_APPLICATION(Version.V1,"/loan-application/{0}"),
        SEND_FOR_HO_APPROVAL(Version.V1,"/loan-application/send-loan-application/{0}/ho-approval"),
        SAVE_MAPPED_LOAN(Version.V1,"/loan-application/saveMappedLoan/{0}"),
        DEMAND_PUSH(Version.V1,"/loan-application/{0}/demand-push"),
        CIS_CUSTOMER_INFO(  "/customerinfo"),
        CIS_LEAD("/lead"),
        CIS_LEAD_REGISTER("/customerinfo/lead/register"),
        CIS_CREATE_UPDATE_CUSOTMER("/customerinfo/createupdatecustomer"),
        CIS_ADD_LEAD_ADDRESS("/lead/{0}/address"),
        GET_LEAD_ADDRESS("/lead/{0}/address"),
        ZOHO_TOKEN("/oauth/v2/token"),
        ZOHO_LEAD("/crm/v2/Leads"),
        ZOHO_LEAD_SEARCH("/crm/v2/Leads/search"),
        ZOHO_CUSTOMER("crm/v2/Contacts"),
        ZOHO_CUSTOMER_SEARCH("crm/v2/Contacts/search"),
        OPS_LENDING_PARTNER(ApiContext.API,"/support/fetchlendingpartners"),
        CIS_GET_PROFILE("/rupeek-web/api/opsAdmin/getprofile"),
        CIS_GET_CUSTOMER("/rupeek-web/api/support/getCustomerDetails"),
        CIS_VERIFY_OTP("/customerinfo/otp/verify"),
        CIS_GENERATE_OTP("/customerinfo/otp/generate"),


        CORE_CITIES(ApiContext.API, "/public/getcities"),
        CITIES("/mds/api/v1/cities?includeinactive=true&sortBy=id"),
        CORE_CHECK_ACTIVE_CUSTOMER(ApiContext.API, "/support/checkactiveloan"),

        // Event Info End points
        EVENT_INFO(ApiContext.API, Version.V1, "/events/EventInfo"),
        EVENT_ENDPOINT_DETAILS(ApiContext.API, Version.V1, "/events/EndPointDetails"),
        EVENT_DESTINATION_DETAILS(ApiContext.API, Version.V1, "/events/EventDestDetails"),
        EVENT_DESTINATION_MAPPING(ApiContext.API, Version.V1, "/events/EventDestDetails"),

        //Scheme
        MASTER_SCHEME_V1(ApiContext.API, Version.V1, "/masterschemes"),
        MASTER_SCHEME(ApiContext.API, Version.V2, "/masterschemes?fields=baseSchemes,displayConfigs,charges,eligibility&enabled=true,false&scrollId={0}&json=true"),
        MASTER_SCHEME_CREATION("/api/superuser/v2/schemecreation"),
        ELIGIBILITY(ApiContext.API, Version.V1, "/masterschemes/{0}/eligibilities"),
        ELIGIBILITY_FETCH(ApiContext.API, Version.V1, "/eligibilities/{0}"),
        DISPLAY_CONFIG(ApiContext.API, Version.V1, "/masterschemes/{0}/displayconfigs"),
        DISPLAY_CONFIG_FETCH(ApiContext.API, Version.V1, "/displayconfigs/{0}"),
        ADDON_FETCH(ApiContext.API, Version.V1, "/addons/{0}"),
        MASTER_SCHEME_DISABLE(ApiContext.API, Version.V1, "/masterschemes/{0}"),

        //Data Adapter
        CREDIT_SCORE(ApiContext.API, Version.V1, "/credit_score"),
        CREDIT_SCORE_V2(ApiContext.API, Version.V2, "/credit_score"),

        //HEIMDALL
        FETCH_GOLD_PRICE(ApiContext.API, Version.V1, "/gold-price/{0}"),

        //CAS
        FETCH_CAS_CONFIG(ApiContext.API, Version.V1, "/casconfig/{0}"),
        CREATE_CAS_CONFIG(ApiContext.API, Version.V1, "/casconfig"),
        FETCH_YIELD("/app/predict"),
        DATA_MIGRATOR(ApiContext.API, Version.V1, "/migrateCustomer/customerLoans/{0}"),

        //DecisionEngine
        CREATE_DecisionEngine_CONFIG(ApiContext.API, Version.V1, "/configs"),

        //Loan Application
        LOAN_APPLICATION_FETCH_BY_LOAN_APPLICATION_ID(Version.V1, "/loan-application/get-loan-applications?search_id_type=CUSTOMER_ID&search_id=&status=CREATED,APPROVAL_PENDING,SYSTEM_REJECT,NEEDS_MODIFICATION,APPROVED,SCHEDULED&id={0}"),
        LOAN_APPLICATION_FETCH_BY_CUSTOMER_ID(Version.V1, "/loan-application/get-loan-applications?search_id_type=CUSTOMER_ID&search_id={0}&status=CREATED,APPROVAL_PENDING,SYSTEM_REJECT,NEEDS_MODIFICATION,APPROVED,SCHEDULED&id="),
        LOAN_APPLICATION_FETCH_APPROVED_LOANS(Version.V1,"/loan-application/get-loan-applications?status=APPROVED&size=251"),
        REASSIGN_DRAFT(Version.V1,"/loan-application/{0}/reassignScheduledBy"),

                //Channel cast java
        CC_JAVA_LISTS("lists"),
        CC_JAVA_LIST_NAME("/lists/{0}"),
        CC_JAVA_LIST_LEAD("/lists/{0}/leads"),
        CC_JAVA_DND_LISTS("lists/dnd"),
        CC_JAVA_LIST_SEARCH("lists/search"),
        CC_JAVA_LIST_SUBSCRIBE("lists/{0}/subscribe"),
        CC_JAVA_LEADS("/leads/{0}"),
        CC_JAVA_LEAD("/leads"),
        CC_JAVA_CAMPAIGN_APPLICATION("application"),
        CC_JAVA_CAMPAIGN_TYPE("/campaign-type"),
        CC_JAVA_CAMPAIGN_CHANNEL("/campaign-channel"),
        CC_JAVA_CAMPAIGN("/campaigns"),
        CC_JAVA_ALL_CAMPAIGN("/applications/{0}/campaigns"),

        CC_JAVA_SEGMENT("/segments"),
        CC_JAVA_SEGMENT_LIST("/segments/segmentList"),

        //Channel cast Notification
        CC_NOTIFICATION_APPLICATION("/application"),
        CC_NOTIFICATION_SMS_TEMPLATE_LIST("applications/{0}/templates/sms"),
        CC_NOTIFICATION_EMAIL_TEMPLATE_LIST("applications/{0}/templates/email"),
        CC_NOTIFICATION_CALL_TEMPLATE_LIST("applications/{0}/templates/telephony"),
        CC_NOTIFICATION_SMS_TEMPLATE("template/sms"),
        CC_NOTIFICATION_EMAIL_TEMPLATE("template/email"),
        CC_NOTIFICATION_CALL_TEMPLATE("template/telephony"),
        CC_NOTIFICATION_CATEGORY("notification-category"),

        CC_NOTIFICATION_SMS_SENDER("/sms-sender"),
        CC_NOTIFICATION_SMS_PROVIDER("/sms-provider"),
        CC_NOTIFICATION_SMS_SENDER_BY_PROVIDER("/sms-provider/{0}/sms-sender"),
        CC_NOTIFICATION_EMAIL_PROVIDER("/email-provider"),
        CC_NOTIFICATION_EMAIL_SENDER("/email-provider/{0}/email-sender"),

        CC_NOTIFICATION_CALL_PROVIDER("/telephony-provider"),
        CC_NOTIFICATION_CALL_SENDER("/telephony-provider/{0}/telephony-sender"),
        CC_NOTIFICATION_CALL_FLOW_INFO("call-flow-info/telephonyProvider"),

        CC_NOTIFICATION_PROVIDER("notification-provider/getAllNotificationProviders"),

        //Digital Journey
        CAPTURE_LEAD("/lead-service/capture-lead?digitalJourney=true"),
        UPDATE_LEAD("/lead-service/capture-lead/update?digitalJourney=true"),
        DJ_SCHEMES("/scheme"),
        PIN_CODE_SERVICE("/insight/pincode-servicable"),
        PIN_CODE_SERVICEABILITY("/insight/pincode-serviceability"),
        LS_SEND_OTP("/v1/otp/leadId"),
        LS_VERIFY_OTP("/v1/otp/verify/leadId"),
        PRIORITY_SLOTS("/insight/view-priority"),
        SLOTS_VIEW("/insight/view-slots"),
        ADD_LEAD_ADDRESS("/lead/{0}/address"),
        DJ_GET_LEAD_DETAILS("/lead-service/leads/{0}"),
       //supportService
        ADD_COMMENT(ApiContext.API, Version.V1,"/ticket/{0}/comment"),
        CREATE_CASE(ApiContext.API,Version.V2,"/ticket"),
        LIST_OF_COMMENT(ApiContext.API,Version.V1,"/ticket/{0}/comment"),
        ADD_IMAGE(ApiContext.API,Version.V1,"/ticket/attachment"),
        LIST_OF_ATTACHMENT(ApiContext.API,Version.V1,"/ticket/{0}/attachment"),
        FETCH_CS_TOKEN(ApiContext.API,Version.V1,"/auth/token"),

        //LeadService
        FETCH_PRIORITY("/slots/priority-list"),
        FETCH_SLOT("/slots"),
        CREATE_LEAD("/v1/lead"),
        UPDATE_LOAN_TYPE("/v1/lead/{0}"),



        //Referral
        UPDATE_REFERRAL_API("/api/v1/referral"),
        PAYMENTLIST_API("/api/v1/referral/paymentlist"),

        // chakra
        CHAKRA_AUTH_TOKEN("/auth/token"),
        CHAKRA_ATTRIBUTES("/attribute"),
        CHAKRA_PROCEDURE_PROCESS("/procedure/{0}/process"),
        CHAKRA_LIST("/procedure/{0}/process/list"),

        //scheduling service
        FETCH_LENDING_PARTNERS(Version.V1,"/loan/draft/lending-partners"),
        FETCH_ALL_DRAFT( Version.V1,"/loan/draft/fetch"),
        LOAN_ID(Version.V1,"/loan/draft/all-loans"),
        FETCH_DRAFT_BY_LOAN_APPLICATION_ID(Version.V1,"/loan/draft/get-drafts-by-loan-ids"),
        FETCH_ALL_EXCEPTION(Version.V1,"/draft/exceptions/"),
        FETCH_ALL_REJECTION(Version.V1,"/draft/rejection/reasons"),
        INSERT_DRAFT(Version.V1,"/loan/draft"),
        APPROVE_DRAFT(Version.V1,"/loan/draft/{0}/approve"),
        UPDATE_WITH_LOAN(Version.V1,"/loan/draft/0/update-with-loan"),
        REJECT_DRAFT(Version.V1,"/loan/draft/{0}/reject"),
        RESCHEDULE_DRAFT(Version.V1,"/loan/draft/{0}/reschedule"),
        DELETE_DRAFT(Version.V1, "/loan/draft/{0}"),



        //Insight service
        GET_DETAILS_FROM_INSIGHT(ApiContext.API,Version.V3,"/transactions/disbursements/queue"),
        INSERT_AGENT_TO_GROUP(ApiContext.API,Version.V1,"/groups/{0}"),
        ADD_SHIFT_TO_USER(ApiContext.API,Version.V1,"/agents/{0}/availability"),
        USER_LOGIN(ApiContext.API,Version.V1,"/auth/login"),
        GET_GROUP(ApiContext.API,Version.V1,"/groups"),
        GET_SHIFT(ApiContext.API,Version.V1,"/shifts"),
        GET_HUB_ID(ApiContext.API,Version.V1,"/places"),
        GET_PRIORITY(ApiContext.API,Version.V1,"/priorities"),
        ARCHIVE_TRANSACTION(ApiContext.API, Version.V1,"/transactions/{0}/archive"),


        //Gold stream
        GET_GOLD_RATE_FOR_TODAY(ApiContext.API,Version.V1,"/gold-price/{0}"),
        SUGGESTED_SCHEME(ApiContext.API,Version.V1,"/suggested-schemes"),
        CREATE_CUSTOMER(ApiContext.API,Version.V1,"/customers"),
        //DisbursementEngine
        DE_WEBHOOK("/receiver"),
        DE_ACCOUNT_VALIDATION("/disbursement/account/validation"),
        DE_ACCOUNT_VALIDATION_BY_ADMIN("/disbursement/account/validation/admin"),
        DE_POST_PAYOUT_REQUEST("/disbursement/payout"),

        //RupeekQuick
        WITHDRAW_REQUEST("/withdrawal"),
        WITHDRAW_OTP("/withdrawal/resendOTP"),
        GET_PAYMENT("/v2/payments"),
        CREATE_PAYMENT("/payment"),
        CONFIRM_PAYMENT("/payment/confirm"),
        CANCEL_PAYMENT("/payment/cancel"),
        GET_USER_JEWELS("/user/jewels"),
        CALCULATE_RELEASE("/release/calculate"),
        INITIATE_RELEASE("/release/initiate"),
        GET_RELEASE_OTP("/release/{0}/otp?voice=false"),
        GET_RENEWAL_MASTERSCHEME("/user/eligible-master-schemes"),
        CALCULATE_RENEWAL("/v1/renewals/calculate"),
        INITIATE_RENEWAL("/v1/renewals/initiate"),
        GET_RENEWAL_OTP("/v1/renewals/{0}/otp?voice=false"),

        //FedMIS Service
        FED_CREATE_LOAN("/api/loans"),
        SET_PREFERENCE("/cards/set-preferences"),

        //Comm Engine
        INSERT_TEMPLATE("/comm/web/notification-template"),
        INSERT_SERVICE_PROVIDER_SCHEMA("/comm/web/service_provider_schema"),
        INSERT_SERVICE_PROVIDER_DETAILS("/comm/web/service_provider_details"),

        //CustomerBff
        Fetch_SCHEME("/scheme"),


        //AgentService
        SEND_OTP("/v1/otp/send"),
        VERIFY_OTP("/v1/otp/verify"),

        //Account Service
        CREATE_LOAN("/loans/1:1"),
        DELETE_LOAN("/loans"),
        //Customer Loan
        FETCH_LOAN_DETAILS("/rpkweb/api/v3/customer/activeloans"),

        //Andromeda
        ESIGN_REQUEST("/api/v1/loanrequest/{0}/esignrequest");




        private final String pathName;

        Resource(ApiContext apiContext,  String resource) {
            this(apiContext, Version.NONE, resource);
        }

        Resource(ApiContext apiContext,Version version, String resource) {

            this.pathName = ""+ apiContext + version + resource ;
        }

        Resource(Version version, String resource) {

            this.pathName = "" + version + resource ;
        }

        Resource(String resource){ this.pathName=resource; }

        Resource(String api, Version version, String resource) {
            this.pathName = api + version + resource;
        }

        public String toString(String... params) {
            if (params == null || params.length == 0)
                return toString();
            String replacedPath = this.pathName;
            int i = 0;
            for (; i < params.length; i++) {
                if (replacedPath.indexOf("$" + i) == -1)
                    break;
                replacedPath = replacedPath.replace("$" + i, params[i]);
            }
            for (; i < params.length; i++)
                replacedPath = replacedPath + "/" + params[i];

            return replacedPath;
        }

        @Override
        public String toString() {
            return pathName;
        }
    }
}