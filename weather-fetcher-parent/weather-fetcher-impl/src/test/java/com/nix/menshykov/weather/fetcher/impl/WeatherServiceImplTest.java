package com.nix.menshykov.weather.fetcher.impl;

import com.nix.menshykov.weather.fetcher.api.model.WeatherModel;
import com.nix.menshykov.weather.fetcher.impl.openweather.exception.FailedToGetWeatherException;
import com.nix.menshykov.weather.fetcher.impl.openweather.OpenWeatherProperties;
import com.nix.menshykov.weather.fetcher.impl.openweather.model.*;
import com.nix.menshykov.weather.fetcher.impl.openweather.OpenWeatherApi;
import com.nix.menshykov.weather.fetcher.impl.openweather.mapper.WeatherMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceImplTest {

    @Mock
    OpenWeatherApi openWeatherApi;

    @Mock
    OpenWeatherProperties propsHolder;

    @Test
    public void getWeatherByValidCityTest() {

        OpenWeatherModel openWeatherModel = TestObjectsCreator.createCommonOpenWeatherModel();
        WeatherModel weatherModel = TestObjectsCreator.createCommonWeatherModel();
        WeatherMapper weatherMapper = WeatherMapper.INSTANCE;

        Mockito.when(openWeatherApi.getWeatherByCity(TestObjectsCreator.CITY + "," + TestObjectsCreator.COUNTRY_CODE,
                TestObjectsCreator.ID, TestObjectsCreator.UNITS))
                .thenReturn(openWeatherModel);
        Mockito.when(propsHolder.getAppId()).thenReturn(TestObjectsCreator.ID);
        Mockito.when(propsHolder.getUnits()).thenReturn(TestObjectsCreator.UNITS);

        WeatherServiceImpl weatherService = new WeatherServiceImpl(openWeatherApi, propsHolder, weatherMapper);

        Assert.assertEquals(weatherService.getWeatherByCity(TestObjectsCreator.COUNTRY_CODE, TestObjectsCreator.CITY), weatherModel);
    }

    @Test (expected = FailedToGetWeatherException.class)
    public void getWeatherByInvalidCityFailed() throws RuntimeException {
        Mockito.when(openWeatherApi.getWeatherByCity("InvalidCity," + TestObjectsCreator.COUNTRY_CODE,
                TestObjectsCreator.ID,
                TestObjectsCreator.UNITS))
                .thenThrow(new FailedToGetWeatherException("404: failed to load weather"));
        WeatherMapper weatherMapper = WeatherMapper.INSTANCE;
        WeatherServiceImpl weatherService = new WeatherServiceImpl(openWeatherApi, propsHolder, weatherMapper);
        Mockito.when(propsHolder.getAppId()).thenReturn(TestObjectsCreator.ID);
        Mockito.when(propsHolder.getUnits()).thenReturn(TestObjectsCreator.UNITS);
        weatherService.getWeatherByCity(TestObjectsCreator.COUNTRY_CODE, "InvalidCity");
    }

}