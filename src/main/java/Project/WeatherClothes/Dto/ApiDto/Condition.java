package Project.WeatherClothes.Dto.ApiDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Condition {
    private String text;
    private String icon;
    private int code;

    public Condition(@JsonProperty("text") String text,
                     @JsonProperty("icon") String icon,
                     @JsonProperty("code") int code){
        this.text = text;
        this.icon = icon;
        this.code = code;
    }
}
