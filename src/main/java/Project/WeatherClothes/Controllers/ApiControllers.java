package Project.WeatherClothes.Controllers;

import Project.WeatherClothes.Aspect.anno.Counter;
import Project.WeatherClothes.Aspect.anno.Timer;
import Project.WeatherClothes.Service.ApiWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequiredArgsConstructor
public class ApiControllers {

    private final ApiWeatherService apiWeatherService;

    @Timer
    @PostMapping("api")
    public String apiWeather(@RequestBody String city, Principal principal) {
        return apiWeatherService.predictionWeather(apiWeatherService.getApiWeather(city), principal);
    }
}
