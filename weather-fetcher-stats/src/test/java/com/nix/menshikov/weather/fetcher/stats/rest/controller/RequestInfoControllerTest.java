package com.nix.menshikov.weather.fetcher.stats.rest.controller;

import com.nix.menshikov.weather.fetcher.stats.jpa.service.RequestInfoService;
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

@WebMvcTest(RequestInfoController.class)
public class RequestInfoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RequestInfoService requestInfoService;

    @Test
    public void correctAmountOfRequestsBetweenTimesJsonTest() throws Exception {
        Time start = Time.valueOf("10:00:00");
        Time end = Time.valueOf("11:00:00");
        long amount = 10;

        when(requestInfoService.getAmountOfRequestsInPeriodOfTime(start, end)).thenReturn(amount);

        this.mvc.perform(get("/weather-stats/requests/amount?start=10:00:00&end=11:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount", is(10)));
    }

}
