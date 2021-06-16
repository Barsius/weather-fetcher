package com.nix.menshykov.weather.fetcher.api.model;

import lombok.*;

@Builder
@Getter
@EqualsAndHashCode
public class WeatherModel {

    private String name;
    private String description;
    private double temp;
    private double tempFeeling;
    private double windSpeed;

}