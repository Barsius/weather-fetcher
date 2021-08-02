package com.nix.menshikov.weather.fetcher.stats.jpa.repository;

import com.nix.menshikov.weather.fetcher.stats.jpa.entity.RequestInfo;
import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CityStatsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface RequestInfoRepository extends JpaRepository<RequestInfo, Integer> {

    @Query("SELECT DISTINCT r.countryCode as countryCode, r.city as city, COUNT(r.city) as amountOfRequests \n" +
            "FROM RequestInfo r \n" +
            "GROUP BY r.city \n" +
            "ORDER BY COUNT(r.city) DESC")
    List<CityStatsProjection> getCitiesByPopularity();

    long countByTimeBetweenAndDateBetween(Time timeStart, Time timeEnd, Date startDate, Date endDate);

}
