package Project.WeatherClothes.Controllers;

import Project.WeatherClothes.Dto.ApiDto.CurrentWeather;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import okhttp3.Request;
import okhttp3.Response;


@RestController
public class ApiControllers {

    private static final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    @PostMapping("api")
    public String apiWeather() {
        Request request = new Request.Builder()
                .url("https://weatherapi-com.p.rapidapi.com/current.json?q=Ekaterinburg&days=1&lang=ru")
                .header("X-RapidAPI-Key", "1b3fa64eedmsh94cfdf0245cfb08p182712jsn25e7b786733d")
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .header("accept", "application/json")
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        CurrentWeather currentWeather = mapper.readValue(response.body().byteStream(),CurrentWeather.class);

        return currentWeather.getLocation().getName();
    }
}
