package Project.WeatherClothes.Service;

import Project.WeatherClothes.Dto.ClothesDto.ClothesWeb;
import Project.WeatherClothes.Dto.Registration.UserWeb;

public interface AdminAddtion {

    void createAdmin(UserWeb userWeb);

    void createClothes(ClothesWeb clothesWeb);
}
