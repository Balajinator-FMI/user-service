package com.fmicodesproj.fmiprojuserservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdvisorServiceResponse {
    private String recOutdoor;
    private String advice;
    private String factor;
}
