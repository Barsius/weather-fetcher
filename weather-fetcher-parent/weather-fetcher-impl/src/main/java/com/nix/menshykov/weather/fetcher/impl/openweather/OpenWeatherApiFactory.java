package com.nix.menshykov.weather.fetcher.impl.openweather;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.nix.menshykov.weather.fetcher.impl.exception.mapper.ResponseExceptionMapperImpl;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import java.util.Arrays;

public class OpenWeatherApiFactory {

    public static OpenWeatherApi create(String baseUrl) {
        return JAXRSClientFactory.create(baseUrl,
                OpenWeatherApi.class,
                Arrays.asList(new JacksonJsonProvider(), new ResponseExceptionMapperImpl()));
    }

}