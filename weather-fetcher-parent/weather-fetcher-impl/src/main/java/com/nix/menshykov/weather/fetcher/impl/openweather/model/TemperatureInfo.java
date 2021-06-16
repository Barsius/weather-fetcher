package com.nix.menshykov.weather.fetcher.impl.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureInfo {

    private double temp;
    @JsonProperty("feels_like")
    private double tempFeeling;

}
