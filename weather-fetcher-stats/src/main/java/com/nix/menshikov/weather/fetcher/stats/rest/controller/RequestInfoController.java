package com.nix.menshikov.weather.fetcher.stats.rest.controller;

import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CityStatsProjection;
import com.nix.menshikov.weather.fetcher.stats.jpa.service.RequestInfoService;
import com.nix.menshikov.weather.fetcher.stats.rest.model.AmountOfRequestsInPeriodOfTimeAndDateModel;
import com.nix.menshikov.weather.fetcher.stats.rest.validation.DateTimeFormatInString;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("weather-stats")
@Validated
public class RequestInfoController {

    private final RequestInfoService service;

    @GetMapping("/cities/popularity")
    @Operation(summary = "Get cities and country codes by popularity with amount of requests")
    public List<CityStatsProjection> getCitiesByPopularity() {
        return service.getCitiesByPopularity();
    }

    @Operation(summary = "Get amount of requests in period of time and date")
    @GetMapping("/requests/amount")
    public AmountOfRequestsInPeriodOfTimeAndDateModel getAmountOfRequestsInPeriodOfTime(
            @Param("startTime")
            @Parameter(description = "Starting point of time. Format - 'HH:mm:ss'", example = "11:00:00")
            @DateTimeFormatInString(format = "HH:mm:ss", message = "Required time format: HH:mm:ss")
                    String startTime,
            @Param("endTime")
            @Parameter(description = "Ending point of time. Format - 'HH:mm:ss'", example = "22:00:00")
            @DateTimeFormatInString(format = "HH:mm:ss", message = "Required time format: HH:mm:ss")
                    String endTime,
            @Param("startDate")
            @Parameter(description = "Starting point of date. Format - 'yyyy-MM-dd'", example = "2020-07-01")
            @DateTimeFormatInString(format = "yyyy-MM-dd", message = "Required date format: yyyy-MM-dd")
                    String startDate,
            @Param("endDate")
            @Parameter(description = "Ending point of date. Format - 'yyyy-MM-dd'", example = "2022-07-01")
            @DateTimeFormatInString(format = "yyyy-MM-dd", message = "Required date format: yyyy-MM-dd")
                    String endDate){

        long amount = service.getAmountOfRequestsInPeriodOfTimeAndDate(Time.valueOf(startTime), Time.valueOf(endTime),
                Date.valueOf(startDate), Date.valueOf(endDate));
        return new AmountOfRequestsInPeriodOfTimeAndDateModel(
                Time.valueOf(startTime), Time.valueOf(endTime),
                Date.valueOf(startDate), Date.valueOf(endDate),
                amount);
    }

}