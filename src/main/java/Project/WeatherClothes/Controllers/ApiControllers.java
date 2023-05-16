package Project.WeatherClothes.Controllers;

import Project.WeatherClothes.Service.ApiWeatherService;
import lombok.RequiredArgsConstructor;
import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ApiControllers {

    private final ApiWeatherService apiWeatherService;


    @PostMapping("api")
    public String apiWeather(@RequestBody String city) {
        return apiWeatherService.getApiWeather(city);
    }
}
