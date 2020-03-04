package com.weatherstack.api.services;

import io.restassured.response.Response;

public class ForecastEndpoint extends AbstractService {
    private static final String FORECAST = BASE_URL + "forecast";

    public ForecastEndpoint(String city) {
        request = request().baseUri(FORECAST).queryParam("query", city);
    }

    public ForecastEndpoint withForecastDays(String forecastDays) {
        request = request.queryParam("forecast_days", forecastDays);
        return this;
    }

    public Response getForecast() {
        return request.get(FORECAST);
    }


}
