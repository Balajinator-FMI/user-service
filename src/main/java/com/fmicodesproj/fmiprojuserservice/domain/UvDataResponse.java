package com.fmicodesproj.fmiprojuserservice.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UvDataResponse {
    private List<UvIdxTimeData> uvIdxForecast;
    private List<UvIdxTimeData> uvIdxHistory;
    private CurrentUvData currentUvData;
}
