package openweather;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/data/2.5")
public interface OpenWeatherApi {
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/weather")
    public String getWeatherByCity(@QueryParam("q") String name,
                                       @QueryParam("appid") String id,
                                       @QueryParam("metric") String metric);
}
