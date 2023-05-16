package Project.WeatherClothes.Service;

import Project.WeatherClothes.Dto.ApiDto.CurrentWeather;
import Project.WeatherClothes.impl.WeatherApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
public class ApiWeatherService implements WeatherApi {

    private static final ObjectMapper mapper = new ObjectMapper();
    @SneakyThrows
    @Override
    public String getApiWeather(String city) {
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
        return String.valueOf(currentWeather.getCurrent().getTemp_c());
    }
}
