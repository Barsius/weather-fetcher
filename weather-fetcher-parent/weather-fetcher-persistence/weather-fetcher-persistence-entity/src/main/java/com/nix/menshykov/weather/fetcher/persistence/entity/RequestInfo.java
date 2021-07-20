package com.nix.menshykov.weather.fetcher.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Table(name = "`request_info`")
@Data
@NoArgsConstructor
public class RequestInfo {

    @Column(name = "`request_info_id`")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "`city`")
    private String city;

    @Column(name = "`country_code`")
    private String countryCode;

    @Column(name = "`time`")
    private Time time;

    public RequestInfo(String city, String countryCode, Time time) {
        this.city = city;
        this.countryCode = countryCode;
        this.time = time;
    }

}
