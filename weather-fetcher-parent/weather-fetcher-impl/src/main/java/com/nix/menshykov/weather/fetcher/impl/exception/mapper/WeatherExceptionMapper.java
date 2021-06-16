package com.nix.menshykov.weather.fetcher.impl.exception.mapper;

import com.nix.menshykov.weather.fetcher.impl.openweather.exception.FailedToGetWeatherException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class WeatherExceptionMapper implements ExceptionMapper<FailedToGetWeatherException> {

    @Override
    public Response toResponse(FailedToGetWeatherException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }

}
