package com.nix.menshikov.weather.fetcher.stats;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestInfoController {

    private final RequestInfoRepository requestInfoRepository;

    @GetMapping("/citiesByPopularity")
    public List<String> getCitiesByPopularity() {
        return requestInfoRepository.getCitiesByPopularity();
    }

    @GetMapping("/betweenTwoDates")
    public Long countRequestsBetweenTwoDates(@Param("start") Time start, @Param("end") Time end) {
        return requestInfoRepository.countByTimeBetween(start, end);
    }

}