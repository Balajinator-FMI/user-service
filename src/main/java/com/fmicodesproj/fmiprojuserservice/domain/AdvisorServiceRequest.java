package com.fmicodesproj.fmiprojuserservice.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AdvisorServiceRequest {
    private BiologicalSex biologicalSex;
    private Short years;
    private SkinType skinType;
    private List<SkinDisease> skinDiseases;
    private Double uvIndex;
    private Double temperatureC;
    private String weather;
}
