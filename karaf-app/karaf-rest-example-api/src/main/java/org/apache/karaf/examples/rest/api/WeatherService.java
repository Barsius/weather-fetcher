package org.apache.karaf.examples.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public interface WeatherService  {
    @Path("/{city}")
    @Produces("application/json")
    @GET
    public Weather getWeatherByCity(@PathParam("city") String city);
}
