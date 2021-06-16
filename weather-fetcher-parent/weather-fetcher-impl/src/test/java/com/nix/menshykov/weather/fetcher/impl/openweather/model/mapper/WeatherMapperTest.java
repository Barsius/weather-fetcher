package com.nix.menshykov.weather.fetcher.impl.openweather.model.mapper;

import com.nix.menshykov.weather.fetcher.api.model.WeatherModel;
import com.nix.menshykov.weather.fetcher.impl.TestObjectsCreator;
import com.nix.menshykov.weather.fetcher.impl.openweather.mapper.WeatherMapper;
import com.nix.menshykov.weather.fetcher.impl.openweather.model.OpenWeatherModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherMapperTest {

    @Test
    public void openWeatherModelToWeatherModelTest() {
        OpenWeatherModel openWeatherModel = TestObjectsCreator.createCommonOpenWeatherModel();
        WeatherModel expectedWeatherModel = TestObjectsCreator.createCommonWeatherModel();
        WeatherModel actualWeatherModel = WeatherMapper.INSTANCE.openWeatherModelToWeatherModel(openWeatherModel);
        assertEquals(expectedWeatherModel, actualWeatherModel);
    }

}