package com.nix.menshikov.weather.fetcher.stats.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "`request_info`")
@Data
@NoArgsConstructor
public class RequestInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_info_id")
    private int id;

    private String city;

    @Column(name = "country_code")
    private String countryCode;

    private Time time;

    private Date date;

    public RequestInfo(String city, String countryCode, Time time, Date date) {
        this.city = city;
        this.countryCode = countryCode;
        this.time = time;
        this.date = date;
    }

}
