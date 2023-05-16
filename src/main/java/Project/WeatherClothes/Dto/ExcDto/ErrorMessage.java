package Project.WeatherClothes.Dto.ExcDto;

import lombok.Data;

@Data
public class ErrorMessage {

    private String field;
    private String message;

    public ErrorMessage(String s, String s1) {
        this.field = s;
        this.message = s1;
    }
}
