package com.nix.menshikov.weather.fetcher.stats.repository;

import com.nix.menshikov.weather.fetcher.stats.MockDataRequestInfo;
import com.nix.menshikov.weather.fetcher.stats.jpa.projection.CityStatsProjection;
import com.nix.menshikov.weather.fetcher.stats.jpa.repository.RequestInfoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RequestInfoRepositoryTest {

    @Autowired
    RequestInfoRepository repository;

    @Before
    public void before() {
        repository.saveAll(MockDataRequestInfo.createRequestList());
    }

    @Test
    public void correctMostPopularCityInCitiesByPopularityTest() {
        List<CityStatsProjection> countryStats = repository.getCitiesByPopularity();
        assertThat(countryStats.get(0).getCity())
                .isEqualTo("City1");
    }

    @Test
    public void correctAmountOfRequestsBetweenTimesTest() {
        long amount = repository.countByTimeBetweenAndDateBetween(Time.valueOf("09:30:00"), Time.valueOf("11:30:00"),
                Date.valueOf("2020-08-02"), Date.valueOf("2022-08-02"));
        assertThat(amount)
                .isEqualTo(2);
    }

    @Test
    public void zeroAmountOfRequestsBetweenTimesTest() {
        long amount = repository.countByTimeBetweenAndDateBetween(Time.valueOf("22:00:00"), Time.valueOf("23:00:00")
                , Date.valueOf("2020-08-02"), Date.valueOf("2022-08-02"));
        assertThat(amount)
                .isEqualTo(0);
    }

}
