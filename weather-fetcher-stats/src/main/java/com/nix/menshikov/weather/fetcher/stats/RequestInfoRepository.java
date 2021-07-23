package com.nix.menshikov.weather.fetcher.stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.util.List;

public interface RequestInfoRepository extends JpaRepository<RequestInfo, Integer> {

    @Query("SELECT DISTINCT r.countryCode, r.city, COUNT(r.city) \n" +
            "FROM RequestInfo r \n" +
            "GROUP BY r.city \n" +
            "ORDER BY COUNT(r.city) DESC")
    List<String> getCitiesByPopularity();

    long countByTimeBetween(Time start, Time end);

}
