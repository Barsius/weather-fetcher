package com.nix.menshykov.weather.fetcher.impl;

import com.nix.menshykov.weather.fetcher.api.WeatherService;
import com.nix.menshykov.weather.fetcher.impl.openweather.OpenWeatherProperties;
import com.nix.menshykov.weather.fetcher.impl.openweather.mapper.WeatherMapper;
import com.nix.menshykov.weather.fetcher.api.model.WeatherModel;
import com.nix.menshykov.weather.fetcher.impl.openweather.OpenWeatherApi;
import com.nix.menshykov.weather.fetcher.impl.openweather.model.OpenWeatherModel;
import com.nix.menshykov.weather.fetcher.persistence.entity.RequestInfo;
import com.nix.menshykov.weather.fetcher.persistence.repository.RequestInfoRepository;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.util.Date;

@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final OpenWeatherApi openWeatherApi;
    private final OpenWeatherProperties properties;
    private final WeatherMapper weatherMapper;
    private final RequestInfoRepository requestInfoRepository;

    @Override
    public WeatherModel getWeatherByCity(String code, String city) {
        OpenWeatherModel openWeatherModel = openWeatherApi.getWeatherByCity(getCityAndCode(city, code),
                properties.getAppId(),
                properties.getUnits());

        requestInfoRepository.add(new RequestInfo(city, code, new Time(new Date().getTime())));

        return weatherMapper.openWeatherModelToWeatherModel(openWeatherModel);
    }

    private String getCityAndCode(String city, String code) {
        return String.format("%s,%s", city, code);
    }

}