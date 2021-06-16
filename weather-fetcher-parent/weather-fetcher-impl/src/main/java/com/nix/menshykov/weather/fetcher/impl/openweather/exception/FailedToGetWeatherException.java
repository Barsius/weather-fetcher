package com.nix.menshykov.weather.fetcher.impl.openweather.exception;

public class FailedToGetWeatherException extends RuntimeException {

    public FailedToGetWeatherException(String msg) {
        super(msg);
    }

}
