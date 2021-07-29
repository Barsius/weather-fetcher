package com.nix.menshikov.weather.fetcher.stats.jpa.service.impl;

import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CityStatsProjection;
import com.nix.menshikov.weather.fetcher.stats.jpa.repository.RequestInfoRepository;
import com.nix.menshikov.weather.fetcher.stats.jpa.service.RequestInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestInfoServiceImpl implements RequestInfoService {

    private final RequestInfoRepository repository;

    @Override
    public List<CityStatsProjection> getCitiesByPopularity() {
        return repository.getCitiesByPopularity();
    }

    @Override
    public long getAmountOfRequestsInPeriodOfTime(Time start, Time end) {
        return repository.countByTimeBetween(start, end);
    }
}
