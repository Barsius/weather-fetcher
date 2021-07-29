package com.nix.menshikov.weather.fetcher.stats.jpa.projection;

public interface CityStatsProjection {

    String getCountryCode();
    String getCity();
    long getAmountOfRequests();

    String setCountryCode(String countryCode);
    String setCity(String city);
    long setAmountOfRequests(long amountOfRequests);

}
