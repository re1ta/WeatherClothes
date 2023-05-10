package Project.WeatherClothes.Dto.ApiDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
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

    public Current(@JsonProperty("last_updated_ep") int last_updated_epoch,
                   @JsonProperty("last_updated") String last_updated,
                   @JsonProperty("temp_c")          int temp_c,
                   @JsonProperty("temp_f")          int temp_f,
                   @JsonProperty("is_day")          int is_day,
                   @JsonProperty("condition") Condition condition,
                   @JsonProperty("wind_mph")        int wind_mph,
                   @JsonProperty("wind_kph")        int wind_kph,
                   @JsonProperty("wind_degree")     int wind_degree,
                   @JsonProperty("ng wind_dir")  String wind_dir,
                   @JsonProperty("pressure_mb")     int pressure_mb,
                   @JsonProperty("pressure_in")     int pressure_in,
                   @JsonProperty("precip_mm")       int precip_mm,
                   @JsonProperty("precip_in")       int precip_in,
                   @JsonProperty("humidity")        int humidity,
                   @JsonProperty("cloud")           int cloud,
                   @JsonProperty("feelslike_c")     int feelslike_c,
                   @JsonProperty("feelslike_f")     int feelslike_f,
                   @JsonProperty("vis_km")          int vis_km,
                   @JsonProperty("vis_miles")       int vis_miles,
                   @JsonProperty("uv")              int uv,
                   @JsonProperty("gust_mph")        int gust_mph,
                   @JsonProperty("gust_kph")        int gust_kph){
        this.last_updated_epoch = last_updated_epoch;
        this.last_updated = last_updated;
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.is_day = is_day;
        this.condition = condition;
        this.wind_mph = wind_mph;
        this.wind_kph = wind_kph;
        this.wind_degree = wind_degree;
        this.wind_dir = wind_dir;
        this.pressure_mb = pressure_mb;
        this.pressure_in = pressure_in;
        this.precip_mm = precip_mm;
        this.precip_in = precip_in;
        this.humidity = humidity;
        this.cloud = cloud;
        this.feelslike_c = feelslike_c;
        this.feelslike_f = feelslike_f;
        this.vis_km = vis_km;
        this.vis_miles = vis_miles;
        this.uv = uv;
        this.gust_mph = gust_mph;
        this.gust_kph = gust_kph;
    }
}
