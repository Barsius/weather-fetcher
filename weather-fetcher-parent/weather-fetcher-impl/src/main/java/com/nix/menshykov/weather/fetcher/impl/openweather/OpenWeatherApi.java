package com.nix.menshykov.weather.fetcher.impl.openweather;

import com.nix.menshykov.weather.fetcher.impl.openweather.model.OpenWeatherModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.MessageBodyReader;

@Path("/data/2.5")
public interface OpenWeatherApi extends MessageBodyReader<OpenWeatherModel> {

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/weather")
    OpenWeatherModel getWeatherByCity(@QueryParam("q") String name,
                                      @QueryParam("appid") String id,
                                      @QueryParam("units") String metric);

}
