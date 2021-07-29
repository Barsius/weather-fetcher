package com.nix.menshikov.weather.fetcher.stats.rest.controller;

import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CityStatsProjection;
import com.nix.menshikov.weather.fetcher.stats.jpa.service.RequestInfoService;
import com.nix.menshikov.weather.fetcher.stats.rest.model.AmountBetweenTimesModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("weather-stats")
public class RequestInfoController {

    private final RequestInfoService service;

    @GetMapping("/cities/popularity")
    public List<CityStatsProjection> getCitiesByPopularity() {
        return service.getCitiesByPopularity();
    }

    @GetMapping("/requests/amount")
    public AmountBetweenTimesModel countAmountOfRequestsInPeriodOfTime(@Param("start") Time start,
                                                                       @Param("end") Time end) {
        long amount = service.getAmountOfRequestsInPeriodOfTime(start, end);
        return new AmountBetweenTimesModel(start, end, amount);
    }

}