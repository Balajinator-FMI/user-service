package com.fmicodesproj.fmiprojuserservice.entity;

import com.fmicodesproj.fmiprojuserservice.domain.BiologicalSex;
import com.fmicodesproj.fmiprojuserservice.domain.SkinDisease;
import com.fmicodesproj.fmiprojuserservice.domain.SkinType;
import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    @NonNull
    private BiologicalSex biologicalSex;

    @NonNull
    private Short years;

    @NonNull
    private SkinType skinType;

    @NonNull
    private List<SkinDisease> skinDiseases;
}
