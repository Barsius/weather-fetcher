package com.nix.menshikov.weather.fetcher.stats.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;

@Data
@AllArgsConstructor
public class AmountBetweenTimesModel {

    private Time start;

    private Time end;

    private long amount;

}
