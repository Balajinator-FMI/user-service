package com.fmicodesproj.fmiprojuserservice.domain;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class UvIdxTimeData {
    private Timestamp date;
    private Double uvIndex;
}
