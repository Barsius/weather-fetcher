package com.nix.menshikov.weather.fetcher.stats.jpa.projection;

public interface CountryStatsProjection {

    String getCountryCode();

    String getCity();

    Long getAmount();

}
