package org.apache.karaf.examples.rest.blueprint;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import openweather.OpenWeatherApi;
import openweather.WeatherDTO;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.karaf.examples.rest.api.Weather;
import org.apache.karaf.examples.rest.api.WeatherService;

public class WeatherServiceRest implements WeatherService {
    @Override
    public Weather getWeatherByCity(String city) {
        OpenWeatherApi openWeatherApi = JAXRSClientFactory.create("http://api.openweathermap.org", OpenWeatherApi.class);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        WeatherDTO weatherDTO = gson.fromJson((openWeatherApi.getWeatherByCity(city, "fd666d8196fd3d7b457a6775efcf2ab5", "metric")), WeatherDTO.class);
        return new Weather(weatherDTO.getName());
    }
}