package Project.WeatherClothes.Dto.Registration;

import Project.WeatherClothes.Dto.Registration.Anno.RegistrationConditions;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserWeb {

    @RegistrationConditions
    private String username;

    @RegistrationConditions
    private String password;

    @NotBlank
    private String sex;
}
