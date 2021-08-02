package com.nix.menshikov.weather.fetcher.stats.rest.model.impl;

import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CityStatsProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CityStatsProjectionTestImpl implements CityStatsProjection {

     private String countryCode;
     private String city;
     private long amountOfRequests;

}
