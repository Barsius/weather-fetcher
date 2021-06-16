package com.nix.menshykov.weather.fetcher.impl.openweather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherProperties {

    private String appId;
    private String units;
    private String baseAddress;

}
