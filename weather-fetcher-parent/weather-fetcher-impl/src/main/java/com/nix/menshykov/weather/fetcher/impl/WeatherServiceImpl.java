package com.nix.menshykov.weather.fetcher.impl;

import com.nix.menshykov.weather.fetcher.api.WeatherService;
import com.nix.menshykov.weather.fetcher.impl.openweather.OpenWeatherProperties;
import com.nix.menshykov.weather.fetcher.impl.openweather.mapper.WeatherMapper;
import com.nix.menshykov.weather.fetcher.api.model.WeatherModel;
import com.nix.menshykov.weather.fetcher.impl.openweather.OpenWeatherApi;
import com.nix.menshykov.weather.fetcher.impl.openweather.model.OpenWeatherModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final OpenWeatherApi openWeatherApi;
    private final OpenWeatherProperties properties;
    private final WeatherMapper weatherMapper;

    @Override
    public WeatherModel getWeatherByCity(String code, String city) {
        OpenWeatherModel openWeatherModel = openWeatherApi.getWeatherByCity(getCityAndCode(city, code),
                properties.getAppId(),
                properties.getUnits());
        return weatherMapper.openWeatherModelToWeatherModel(openWeatherModel);
    }

    private String getCityAndCode(String city, String code) {
        return String.format("%s,%s", city, code);
    }

}