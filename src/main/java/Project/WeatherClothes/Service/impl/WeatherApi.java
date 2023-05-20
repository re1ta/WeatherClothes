package Project.WeatherClothes.Service.impl;

import Project.WeatherClothes.Dto.ApiDto.CurrentWeather;

import java.security.Principal;

public interface WeatherApi {

    CurrentWeather getApiWeather(String city);

    String predictionWeather(CurrentWeather currentWeather, Principal principal);
}
