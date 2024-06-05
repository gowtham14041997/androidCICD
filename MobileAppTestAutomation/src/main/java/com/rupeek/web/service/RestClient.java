package com.rupeek.web.service;

import com.rupeek.web.service.RESTApi.Resource;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.MessageFormat;
import java.util.Map;

enum HTTPRequestType {
    GET,
    POST,
    PUT,
    DELETE,
    PATCH
}

public class RestClient {
    private static final Logger LOGGER = LogManager.getLogger(RestClient.class);
    protected RequestSpecification request;
    protected Response response;
    String baseURL;
    String userName;
    String password;

    public RestClient(String baseURL) {
        this.baseURL = baseURL;
    }

    public RestClient(String baseURL, String userName, String password) {
        this.baseURL = baseURL;
        this.userName = userName;
        this.password = password;
        RestAssured.baseURI = baseURL;
        setBasicAuthentication();
    }

    protected void setBasicAuthentication() {
        if (this.userName != null && this.password != null) {
            request.auth().preemptive().basic(userName, password);
        }
    }

    public Response whenRequestIsInvoked(HTTPRequestType requestType, Resource resource, Map<String, String> headers, String payload, String entityId, String queryParameter, String[] urlParams) {
        RestAssured.baseURI = this.baseURL;
        request = RestAssured.given();
        if (headers != null) {
            request.headers(headers);
        }
        String endPoint = formattedUrl(resource, entityId, queryParameter, urlParams);

        if (payload != null) {
            request.body(payload);
        }
        LOGGER.info(String.format("Http Request type : %s",requestType));
        LOGGER.info(String.format("Http Request endpoint: %s",endPoint));
        LOGGER.info(String.format("Http Request payload: %s",headers));
        LOGGER.info(String.format("Http Request payload: %s",payload));

        switch (requestType) {
            case GET:
                if (endPoint != null) {
                    return request.get(endPoint);
                } else return request.get();
            case PUT:
                if (endPoint != null) {
                    return request.put(endPoint);
                } else return request.put();
            case POST:
                if (endPoint != null) {
                    return request.post(endPoint);
                } else return request.post();
            case DELETE:
                if (endPoint != null) {
                    return request.delete(endPoint);
                } else return request.delete();
            case PATCH:
                if (endPoint != null) {
                    return request.patch(endPoint);
                } else return request.patch();
            default:
                throw new RuntimeException("Invalid Request body Type");
        }
    }

    public Response whenGetRequestIsInvoked(Resource resource, Map<String, String> headers, String entityId, String queryParameter, String... urlParams) {
        return whenRequestIsInvoked(HTTPRequestType.GET, resource, headers, null, entityId, queryParameter, urlParams);
    }

    public Response whenGetRequestIsInvoked(Resource response) {
        return whenGetRequestIsInvoked(response, null, null, null, null);
    }

    public Response whenGetRequestIsInvoked(Map<String, String> headers) {
        return whenGetRequestIsInvoked(null, headers, null, null, null);
    }

    public Response whenGetRequestIsInvoked(Resource resource, Map<String, String> headers) {
        return whenGetRequestIsInvoked(resource, headers, null, null, null);
    }

    public Response whenGetRequestIsInvoked(Resource resource, Map<String, String> headers, String entityId) {
        return whenGetRequestIsInvoked(resource, headers, entityId, null, null);
    }


    public Response whenPostRequestIsInvoked(Resource resource, Map<String, String> headers, String payload, String entityId, String queryParameter, String... urlParams) {
        return whenRequestIsInvoked(HTTPRequestType.POST, resource, headers, payload, entityId, queryParameter, urlParams);
    }

    public Response whenPostRequestIsInvoked(Resource resource, Map<String, String> headers, String payload) {
        return whenPostRequestIsInvoked(resource, headers, payload, null, null, null);
    }

    public Response whenPutRequestIsInvoked(Resource resource, Map<String, String> headers, String payload, String entityId, String queryParameter, String... urlParams) {
        return whenRequestIsInvoked(HTTPRequestType.PUT, resource, headers, payload, entityId, queryParameter, urlParams);
    }

    public Response whenPutRequestIsInvoked(Resource resource, Map<String, String> headers, String payload) {

        return whenPutRequestIsInvoked(resource, headers, payload, null, null, null);
    }

    public Response whenPatchRequestIsInvoked(Resource resource, Map<String, String> headers, String payload, String entityId, String queryParameter, String... urlParams) {
        return whenRequestIsInvoked(HTTPRequestType.PATCH, resource, headers, payload, entityId, queryParameter, urlParams);
    }

    public Response whenDeleteRequestIsInvoked(Resource resource, Map<String, String> headers, String payload, String entityId, String queryParameter, String... urlParams) {
        return whenRequestIsInvoked(HTTPRequestType.DELETE, resource, headers, payload, entityId, queryParameter, urlParams);
    }

    public Response whenDeleteRequestIsInvoked(Resource resource, Map<String, String> headers, String entityId) {
        return whenDeleteRequestIsInvoked(resource, headers, entityId, null, null);
    }

    public Response whenDeleteRequestIsInvoked(Resource resource, Map<String, String> headers) {
        return whenDeleteRequestIsInvoked(resource, headers, null, null, null);
    }

    private String formattedUrl(Resource resource, String entityId, String queryParamter, String... urlParams) {
        if (resource == null) {
            return null;
        }
        String endPoint = resource.toString();

        if (queryParamter != null) {
            endPoint = endPoint + "?" + queryParamter;
        }
        if (urlParams != null) {
            endPoint = MessageFormat.format(endPoint, urlParams);
        }
        if (entityId != null) {
            endPoint = endPoint + "/" + entityId;
        }
        LOGGER.info("Endpoint : {}",endPoint);
        return endPoint;
    }

}