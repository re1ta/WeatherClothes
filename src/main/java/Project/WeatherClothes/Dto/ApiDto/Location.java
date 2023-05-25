package Project.WeatherClothes.Dto.ApiDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private String name;
    private String region;
    private String country;
    private int lat;
    private int lon;
    private String tz_id;
    private int localtime_epoch;
    private String localtime;
}
