package com.nix.menshykov.weather.fetcher.api;

import com.nix.menshykov.weather.fetcher.api.model.WeatherModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface WeatherService  {

    @Path("/countryCode/{countryCode}/city/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    WeatherModel getWeatherByCity(@PathParam("countryCode") String countryCode,
                                  @PathParam("city") String city);

}