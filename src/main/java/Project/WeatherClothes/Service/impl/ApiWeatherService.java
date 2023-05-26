package Project.WeatherClothes.Service.impl;

import Project.WeatherClothes.Dto.ApiDto.CurrentWeather;
import Project.WeatherClothes.Dto.ClothesDto.Clothes;
import Project.WeatherClothes.Dto.Registration.Sex;
import Project.WeatherClothes.Dto.Registration.User;
import Project.WeatherClothes.Dto.repos.ClothesRepo;
import Project.WeatherClothes.Service.WeatherApi;
import Project.WeatherClothes.Service.impl.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ApiWeatherService implements WeatherApi {

    private static final ObjectMapper mapper = new ObjectMapper();
    private final UserService userService;
    private final ClothesRepo clothesRepo;

    @Value("${api_host}")
    private String host;

    @Value("${api_key}")
    private String key;

    @SneakyThrows
    @Override
    public CurrentWeather getApiWeather(String city) {
        city = Translator.translate(Language.RUSSIAN, Language.ENGLISH, city);
        String urlApi = "https://weatherapi-com.p.rapidapi.com/current.json?q=" + city + "&lang=ru";
        Request request = new Request.Builder()
                .url(urlApi)
                .header("X-RapidAPI-Key", key)
                .header("X-RapidAPI-Host", host)
                .header("accept", "application/json")
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        CurrentWeather currentWeather = mapper.readValue(response.body().byteStream(),CurrentWeather.class);
        return currentWeather;
    }

    @Override
    public String predictionWeather(CurrentWeather currentWeather,Principal principal) {
        Optional<User> userOptional =  userService.getUserByPrincipal(principal);
        User user = userOptional.get();
        String sex = (user.getSex().iterator().next().getSexName().equals("SEX_MAN")) ? "MAN" : "WOMAN";
        String condition = currentWeather.getCurrent().getCondition().getText();
        int temp = currentWeather.getCurrent().getTemp_c();
        double wind = currentWeather.getCurrent().getWind_kph() / 3.6;
        StringBuilder text = new StringBuilder("Сейчас ").append(temp).append("°C. ").append(condition).append(". ");
        if (condition.contains("дождь")){text.append("Возьмите с собой зонт или дождевик! ");}
        text.append("Как сейчас одеться: ");
        List<String> result = clothesRepo.getClothesDb(sex, temp, wind);
        result.stream().map(cloth -> cloth + ", ").forEach(text::append);
        text.deleteCharAt(text.length()-2);
        return text.toString();
    }
}
