package com.nix.menshikov.weather.fetcher.stats;

import com.nix.menshikov.weather.fetcher.stats.jpa.entity.RequestInfo;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

public class MockDataRequestInfo {

    public static List<RequestInfo> createRequestList() {
        return Arrays.asList(
                new RequestInfo("City1", "country1", Time.valueOf("10:00:00"), Date.valueOf("2021-08-02")),
                new RequestInfo("City1", "country1", Time.valueOf("11:00:00"), Date.valueOf("2021-08-02")),
                new RequestInfo("City2", "country2", Time.valueOf("12:00:00"), Date.valueOf("2021-08-02"))
        );
    }

}
