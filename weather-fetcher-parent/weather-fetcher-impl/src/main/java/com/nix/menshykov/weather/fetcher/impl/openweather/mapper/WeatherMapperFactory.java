package com.nix.menshykov.weather.fetcher.impl.openweather.mapper;

public class WeatherMapperFactory {

    public static WeatherMapper create() {
        return WeatherMapper.INSTANCE;
    }

}
