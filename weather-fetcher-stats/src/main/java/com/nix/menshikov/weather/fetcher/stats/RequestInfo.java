package com.nix.menshikov.weather.fetcher.stats;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "`request_info`")
@Data
public class RequestInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_info_id")
    private int id;

    private String city;

    @Column(name = "country_code")
    private String countryCode;

    private Time time;

}
