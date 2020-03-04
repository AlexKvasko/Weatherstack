package com.weatherstack.api.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class AbstractService {
    protected static final String BASE_URL = "http://api.weatherstack.com/";
    private static final String ACCESS_KEY = "b6c16db9ddfc1cf29229bb54e8c5a9cd";
    protected RequestSpecification request;

    public RequestSpecification request() {
        return given().contentType(ContentType.JSON).queryParam("access_key", ACCESS_KEY);
    }


}
