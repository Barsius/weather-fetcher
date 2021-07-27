package com.nix.menshikov.weather.fetcher.stats.rest.controller;

import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CountryStatsProjection;
import com.nix.menshikov.weather.fetcher.stats.jpa.repository.RequestInfoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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

@WebMvcTest(RequestInfoController.class)
public class RequestInfoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RequestInfoRepository requestInfoRepository;

    @Mock
    private CountryStatsProjection projection;

    @Test
    public void correctAmountOfRequestsBetweenTimesJsonTest() throws Exception {
        Time start = Time.valueOf("10:00:00");
        Time end = Time.valueOf("11:00:00");
        long amount = 10;

        when(requestInfoRepository.countByTimeBetween(start, end)).thenReturn(amount);

        this.mvc.perform(get("/weatherStats/amountBetweenTimes?start=10:00:00&end=11:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount", is(10)));
    }

}
