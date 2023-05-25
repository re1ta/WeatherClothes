package Project.WeatherClothes.Dto.ClothesDto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ClothesWeb {

    @NotBlank
    private String nameClothes;

    @NotNull
    private int temp_c;

    @NotNull
    private double wind_m;

    @NotBlank
    private String sex;

}
