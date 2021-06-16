package com.nix.menshykov.weather.fetcher.impl.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherModel {

    private String name;
    private TemperatureInfo main;
    private List<WeatherDescription> weather;
    private WindInfo wind;

}