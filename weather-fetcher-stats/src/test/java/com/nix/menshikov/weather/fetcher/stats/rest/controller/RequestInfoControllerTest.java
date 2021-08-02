package com.nix.menshikov.weather.fetcher.stats.rest.controller;

import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CityStatsProjection;
import com.nix.menshikov.weather.fetcher.stats.jpa.service.RequestInfoService;
import com.nix.menshikov.weather.fetcher.stats.rest.model.impl.CityStatsProjectionTestImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

import java.sql.Time;
import java.util.Collections;
import java.sql.Date;
import java.util.List;

@WebMvcTest(RequestInfoController.class)
public class RequestInfoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RequestInfoService requestInfoService;

    @Test
    public void correctAmountOfRequestsBetweenTimesJsonTest() throws Exception {
        Time startTime = Time.valueOf("10:00:00");
        Time endTime = Time.valueOf("11:00:00");
        Date startDate = Date.valueOf("2020-08-02");
        Date endDate = Date.valueOf("2022-08-02");
        long amount = 10;

        when(requestInfoService.getAmountOfRequestsInPeriodOfTimeAndDate(startTime, endTime, startDate, endDate)).thenReturn(amount);

        this.mvc.perform(get("/weather-stats/requests/amount?startTime=10:00:00&endTime=11:00:00" +
                "&startDate=2020-08-02&endDate=2022-08-02")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount", is(10)));
    }

    @Test
    public void correctMostPopularCityInCitiesByPopularityInJsonTest() throws Exception {
        CityStatsProjection projection = new CityStatsProjectionTestImpl("Test", "Test", 14);
        List<CityStatsProjection> cities = Collections.singletonList(projection);

        when(requestInfoService.getCitiesByPopularity()).thenReturn(cities);

        this.mvc.perform(get("/weather-stats/cities/popularity")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].city", is("Test")));
    }

}
