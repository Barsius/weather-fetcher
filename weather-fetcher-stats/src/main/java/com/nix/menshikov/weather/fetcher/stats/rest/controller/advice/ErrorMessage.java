package com.nix.menshikov.weather.fetcher.stats.rest.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessage {

    private int status;
    private String message;

}
