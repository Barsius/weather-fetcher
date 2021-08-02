package com.nix.menshikov.weather.fetcher.stats.jpa.service;

import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CityStatsProjection;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface RequestInfoService {

    List<CityStatsProjection> getCitiesByPopularity();

    long getAmountOfRequestsInPeriodOfTimeAndDate(Time timeStart, Time timeEnd, Date dateStart, Date dateEnd);

}
