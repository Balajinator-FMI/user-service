package com.fmicodesproj.fmiprojuserservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class CurrentUvData {
    private Double uvIndex;
    private Double temperatureC;
    private String weather;
    private Timestamp sunrise;
    private Timestamp sunset;
}
