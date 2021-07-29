package com.nix.menshikov.weather.fetcher.stats.jpa.service;

import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CityStatsProjection;

import java.sql.Time;
import java.util.List;

public interface RequestInfoService {

    List<CityStatsProjection> getCitiesByPopularity();

    long getAmountOfRequestsInPeriodOfTime(Time start, Time end);

}
