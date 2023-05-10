package Project.WeatherClothes.Dto.ApiDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentWeather {

    private Location location;

    private Current current;

    public CurrentWeather(@JsonProperty("location") Location location,
                          @JsonProperty("current") Current current) {
        this.location = location;
        this.current = current;
    }
}
