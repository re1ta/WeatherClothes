package Project.WeatherClothes.Dto.ApiDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Location {

    private String name;
    private String region;
    private String country;
    private int lat;
    private int lon;
    private String tz_id;
    private int localtime_epoch;
    private String localtime;

    public Location(@JsonProperty("name") String name,
                    @JsonProperty("region") String region,
                    @JsonProperty("country") String country,
                    @JsonProperty("lat") int lat,
                    @JsonProperty("lon") int lon,
                    @JsonProperty("tz_id") String tz_id,
                    @JsonProperty("localtime_epoch") int localtime_epoch,
                    @JsonProperty("localtime") String localtime) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.tz_id = tz_id;
        this.localtime_epoch = localtime_epoch;
        this.localtime = localtime;
    }
}
