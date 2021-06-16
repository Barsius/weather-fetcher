package com.nix.menshykov.weather.fetcher.impl.exception.mapper;

import com.nix.menshykov.weather.fetcher.impl.openweather.exception.FailedToGetWeatherException;
import org.apache.cxf.jaxrs.client.ResponseExceptionMapper;

import javax.ws.rs.core.Response;

public class ResponseExceptionMapperImpl implements ResponseExceptionMapper<RuntimeException> {

    @Override
    public FailedToGetWeatherException fromResponse(Response response) {
        return new FailedToGetWeatherException(response.getStatus() + ": failed to load weather");
    }

}
