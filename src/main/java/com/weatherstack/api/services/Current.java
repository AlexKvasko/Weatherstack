package com.weatherstack.api.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Current extends AbstractService {
    private static final String CURRENT_WEATHER = BASE_URL+ "current";

    public Response getCurrentWeather(String city){
        return request().queryParam("query", city).get(CURRENT_WEATHER);
    }

}
