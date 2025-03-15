package com.fmicodesproj.fmiprojuserservice.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDataResponse {
    private BiologicalSex biologicalSex;
    private Short years;
    private SkinType skinType;
    private List<SkinDisease> skinDiseases;
    private CurrentUvData currentUvData;
    private List<UvIdxTimeData> forecast;
    private List<UvIdxTimeData> pastWeek;
    private Integer recOutdoor;
    private String advice;
    private Integer factor;
}
