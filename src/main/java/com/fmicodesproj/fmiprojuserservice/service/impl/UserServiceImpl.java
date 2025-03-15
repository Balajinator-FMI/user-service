package com.fmicodesproj.fmiprojuserservice.service.impl;

import com.fmicodesproj.fmiprojuserservice.domain.*;
import com.fmicodesproj.fmiprojuserservice.entity.User;
import com.fmicodesproj.fmiprojuserservice.mapper.UserMapper;
import com.fmicodesproj.fmiprojuserservice.repository.UserRepository;
import com.fmicodesproj.fmiprojuserservice.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final String advisorServiceDataUrl;
    private final String uvServiceDataUrl;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.advisorServiceDataUrl = "http://localhost:9091/advice";
        this.uvServiceDataUrl = "http://localhost:9090/uv";
    }

    @Override
    public UserIDResponse createUser(UserCreateRequest userCreateRequest) {
        User user = userRepository.save(UserMapper.INSTANCE.userRequestToUser(userCreateRequest));
        return UserIDResponse.builder().id(user.getId()).build();
    }

    @Override
    public UserDataResponse getUserDataById(String id, Double lat, Double lon) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found")
        );

        UvDataResponse uvDataResponse = getCurrentUvData(lat, lon);

        AdvisorServiceRequest request = AdvisorServiceRequest.builder()
                .years(user.getYears())
                .biologicalSex(user.getBiologicalSex())
                .skinDiseases(user.getSkinDiseases())
                .skinType(user.getSkinType())
                .uvIndex(uvDataResponse.getCurrentUvData().getUvIndex())
                .temperatureC(uvDataResponse.getCurrentUvData().getTemperatureC())
                .build();

        AdvisorServiceResponse advisorServiceResponse = getAdvisorServiceData(request);

        return UserDataResponse.builder()
                .biologicalSex(user.getBiologicalSex())
                .years(user.getYears())
                .skinType(user.getSkinType())
                .skinDiseases(user.getSkinDiseases())
                .currentUvData(uvDataResponse.getCurrentUvData())
                .forecast(uvDataResponse.getUvIdxForecast())
                .pastWeek(uvDataResponse.getUvIdxHistory())
//                .recOutdoor(null)
//                .advice(null)
//                .factor(null)
                .recOutdoor(advisorServiceResponse.getRecOutdoor())
                .advice(advisorServiceResponse.getAdvice())
                .factor(advisorServiceResponse.getFactor())
                .build();
    }

    @Override
    public List<SkinType> getAllSkinTypes() {
        return List.of(SkinType.values());
    }

    @Override
    public List<SkinDisease> getAllSkinDiseases() {
        return List.of(SkinDisease.values());
    }

    private UvDataResponse getCurrentUvData(Double lat, Double lon) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        String urlWithParams = UriComponentsBuilder.fromUri(URI.create(uvServiceDataUrl))
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .toUriString();

        HttpEntity<UvDataResponse> response = restTemplate.exchange(
                urlWithParams,
                HttpMethod.GET,
                entity,
                UvDataResponse.class
        );

        return response.getBody();
    }

    private AdvisorServiceResponse getAdvisorServiceData(AdvisorServiceRequest advisorServiceRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> entity = new HttpEntity<>(advisorServiceRequest, headers);

        HttpEntity<AdvisorServiceResponse> response = restTemplate.exchange(
                advisorServiceDataUrl,
                HttpMethod.POST,
                entity,
                AdvisorServiceResponse.class);

        return response.getBody();
    }
}
