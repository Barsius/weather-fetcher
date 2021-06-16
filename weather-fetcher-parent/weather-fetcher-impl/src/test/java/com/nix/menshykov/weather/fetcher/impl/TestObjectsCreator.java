package com.nix.menshykov.weather.fetcher.impl;

import com.nix.menshykov.weather.fetcher.api.model.WeatherModel;
import com.nix.menshykov.weather.fetcher.impl.openweather.model.OpenWeatherModel;
import com.nix.menshykov.weather.fetcher.impl.openweather.model.TemperatureInfo;
import com.nix.menshykov.weather.fetcher.impl.openweather.model.WeatherDescription;
import com.nix.menshykov.weather.fetcher.impl.openweather.model.WindInfo;

import java.util.Collections;
import java.util.List;

public class TestObjectsCreator {
    public final static String CITY = "Kharkiv";
    public final static String COUNTRY_CODE = "ua";
    public final static String DESCRIPTION = "few clouds";
    public final static double TEMPERATURE = 30.00;
    public final static double WIND_SPEED = 6.0;
    public final static String ID = "id";
    public final static String UNITS = "metric";

    public static WeatherModel createCommonWeatherModel() {
        return WeatherModel.builder().name(CITY)
                .description(DESCRIPTION)
                .temp(TEMPERATURE)
                .tempFeeling(TEMPERATURE)
                .windSpeed(WIND_SPEED)
                .build();
    }

    public static OpenWeatherModel createCommonOpenWeatherModel() {
        WindInfo windInfo = new WindInfo(WIND_SPEED);
        List<WeatherDescription> weatherDescription = Collections.singletonList(new WeatherDescription(DESCRIPTION));
        TemperatureInfo temperatureInfo = new TemperatureInfo(TEMPERATURE, TEMPERATURE);
        return OpenWeatherModel.builder().name(CITY)
                .main(temperatureInfo)
                .weather(weatherDescription)
                .wind(windInfo)
                .build();
    }

}
