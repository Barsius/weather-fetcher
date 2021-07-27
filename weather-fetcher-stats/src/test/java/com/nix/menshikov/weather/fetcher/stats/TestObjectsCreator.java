package com.nix.menshikov.weather.fetcher.stats;

import com.nix.menshikov.weather.fetcher.stats.jpa.entity.RequestInfo;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

public class TestObjectsCreator {

    public static List<RequestInfo> createRequestList() {
        return Arrays.asList(
                new RequestInfo("City1", "country1", Time.valueOf("10:00:00")),
                new RequestInfo("City1", "country1", Time.valueOf("11:00:00")),
                new RequestInfo("City2", "country2", Time.valueOf("12:00:00"))
        );
    }

}
