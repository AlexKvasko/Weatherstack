package com.weatherstack.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherstack.api.dto.Location;
import com.weatherstack.api.services.Current;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import static com.weatherstack.api.utils.FileUtils.getJsonData;
import static com.weatherstack.api.utils.MapperUtils.mapToObject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import static org.unitils.reflectionassert.ReflectionComparatorMode.IGNORE_DEFAULTS;

public class CurrentWeatherTest {
    private Current currentWeather = new Current();

    @Test(description = "Jira-1234 | Verify location from current weather request", dataProvider = "testDataForCurrentWeather")
    public void verifyCurrentWeatherStatusCodeAndLocation(String city, Location expectedLocation) {
        Response response = currentWeather.getCurrentWeather(city);
        Location actualLocation = response.then().statusCode(200)
                .and().extract().jsonPath().getObject("location", Location.class);
        assertReflectionEquals(expectedLocation, actualLocation, IGNORE_DEFAULTS);
    }

    @DataProvider
    public Object[][] testDataForCurrentWeather() {
        Location kiev = mapToObject(getJsonData("locations", "kiev"), Location.class);
        Location newYork = mapToObject(getJsonData("locations", "new_york"), Location.class);

        return new Object[][]{
                {"Kiev", kiev},
                {"New York", newYork}
        };
    }
}
