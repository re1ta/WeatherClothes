package Project.WeatherClothes.Dto.Registration;

import Project.WeatherClothes.Anno.RegistrationConditions;
import lombok.Data;

@Data
public class UserWeb {

    @RegistrationConditions
    private String username;

    @RegistrationConditions
    private String password;
}
