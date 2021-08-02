package com.nix.menshikov.weather.fetcher.stats.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
public class AmountOfRequestsInPeriodOfTimeAndDateModel {

    private Time startTime;
    private Time endTime;
    private Date startDate;
    private Date endDate;
    private long amount;

}
