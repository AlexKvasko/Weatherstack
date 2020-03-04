package com.weatherstack.api;

import com.weatherstack.api.services.ForecastEndpoint;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ForecastTest {

 // Forecast not supported
    @Test(description = "Jira-3454 | Verify forecast status code and response", dataProvider = "testDataForecast")
    public void verifyCurrentWeatherStatusCodeAndLocation(String city, String forecastDays) {
        Response response = new ForecastEndpoint(city).withForecastDays(forecastDays).getForecast();
        response.then().statusCode(200);
    }

    @DataProvider
    public Object[][] testDataForecast() {
        return new Object[][]{
                {"Kiev", "1"},
                {"New York", "2"}
        };
    }
}
