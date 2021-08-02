package com.nix.menshikov.weather.fetcher.stats.jpa.projection;

public interface CityStatsProjection {

    String getCountryCode();
    String getCity();
    long getAmountOfRequests();

}
