package Project.WeatherClothes.Dto.ClothesDto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ClothesWeb {

    @NotBlank
    private String nameClothes;

    @NotNull
    private int temp_min;

    @NotNull
    private int temp_max;

    @NotNull
    private double wind_min;

    @NotNull
    private double wind_max;

    @NotBlank
    private String sex;
}
