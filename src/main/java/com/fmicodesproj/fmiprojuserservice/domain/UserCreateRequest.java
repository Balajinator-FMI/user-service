package com.fmicodesproj.fmiprojuserservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserCreateRequest {
    private BiologicalSex biologicalSex;
    private Short years;
    private SkinType skinType;
    private List<SkinDisease> skinDiseases;
}
