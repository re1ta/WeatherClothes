package Project.WeatherClothes.Dto.ApiDto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Current {

    private int last_updated_epoch;
    private String last_updated;
    private int temp_c;
    private int temp_f;
    private int is_day;
    private Condition condition;
    private int wind_mph;
    private int wind_kph;
    private int wind_degree;
    private String wind_dir;
    private int pressure_mb;
    private int pressure_in;
    private int precip_mm;
    private int precip_in;
    private int humidity;
    private int cloud;
    private int feelslike_c;
    private int feelslike_f;
    private int vis_km;
    private int vis_miles;
    private int uv;
    private int gust_mph;
    private int gust_kph;
}
