package com.nix.menshikov.weather.fetcher.stats.rest.controller;

import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CountryStatsProjection;
import com.nix.menshikov.weather.fetcher.stats.jpa.repository.RequestInfoRepository;
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
@RequestMapping("weatherStats")
public class RequestInfoController {

    private final RequestInfoRepository requestInfoRepository;

    @GetMapping("/citiesByPopularity")
    public List<CountryStatsProjection> getCitiesByPopularity() {
        return requestInfoRepository.getCitiesByPopularity();
    }

    @GetMapping("/amountBetweenTimes")
    public AmountBetweenTimesModel countRequestsBetweenTimes(@Param("start") Time start, @Param("end") Time end) {
        long amount = requestInfoRepository.countByTimeBetween(start, end);
        return new AmountBetweenTimesModel(start, end, amount);
    }

}