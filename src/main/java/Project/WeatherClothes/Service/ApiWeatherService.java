package Project.WeatherClothes.Service;

import Project.WeatherClothes.Dto.ApiDto.CurrentWeather;
import Project.WeatherClothes.Dto.Registration.User;
import Project.WeatherClothes.Service.impl.WeatherApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApiWeatherService implements WeatherApi {

    private static final ObjectMapper mapper = new ObjectMapper();
    private final UserService userService;

    @SneakyThrows
    @Override
    public CurrentWeather getApiWeather(String city) {
        city = Translator.translate(Language.RUSSIAN, Language.ENGLISH, city);
        String urlApi = "https://weatherapi-com.p.rapidapi.com/current.json?q=" + city + "&lang=ru";
        Request request = new Request.Builder()
                .url(urlApi)
                .header("X-RapidAPI-Key", "1b3fa64eedmsh94cfdf0245cfb08p182712jsn25e7b786733d")
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
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
        boolean sex = user.isSex();
        String condition = currentWeather.getCurrent().getCondition().getText();
        int temp = currentWeather.getCurrent().getTemp_c();
        double wind = currentWeather.getCurrent().getWind_kph() / 3.6;
        String text = "Сейчас " + temp + "°C. " + condition + ". ";
        if (condition.contains("дождь")){text += "Возьмите с собой зонт или дождевик! ";}
        text += "Как сейчас одеться: ";
        if (wind > 18.0){return "Сидите дома, на улице опасный сильный ветер";}
        if (sex){
            if (temp >= 25 && wind < 5.0){return text + "футболка, шорты";}
            else if (temp >= 25 && wind >= 5.0) {return text + "футболка, шорты + ветровка, так как сильный ветер";}
            else if (temp >= 20 && wind < 5.0) {return text + "футболка, штаны/джинсы";}
            else if (temp >= 20 && wind >= 5.0) {return text + "футболка, штаны/джинсы + ветровка, так как сильный ветер";}
        }
        else {
            if (temp >= 25 && wind < 5.0){return text + "блюзка, шорты / платье";}
            else if (temp >= 25 && wind >= 5.0) {return text + "блюзка, шорты + ветровка, так как сильный ветер";}
            else if (temp >= 20 && wind < 5.0) {return text + "блюзка, штаны/джинсы";}
            else if (temp >= 20 && wind >= 5.0) {return text + "блюзка, штаны/джинсы + ветровка, так как сильный ветер";}
        }
        if (temp >= 15 && wind < 5.0) {return text + "футболка, штаны, кофта";}
        else if (temp >= 15 && wind >= 5.0) {return text + "футболка, штаны, демисезонная куртра, так как сильный ветер";}
        else if (temp >= 10){return text + "футболка, штаны, демисезонная куртра/пальто";}
        return "Извините, но мы не можем дать вам точный ответ:(";
    }
}
