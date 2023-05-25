package Project.WeatherClothes.Controllers;

import Project.WeatherClothes.Dto.ClothesDto.Clothes;
import Project.WeatherClothes.Dto.ClothesDto.ClothesWeb;
import Project.WeatherClothes.Dto.Registration.UserWeb;
import Project.WeatherClothes.Dto.repos.ClothesRepo;
import Project.WeatherClothes.Dto.repos.UserRepo;
import Project.WeatherClothes.Service.impl.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RolesAllowed({"ROLE_ADMIN"})
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminControllers {

    private final AdminService adminService;

    @PostMapping("clothes")
    public void newClothes(@RequestBody @Valid ClothesWeb clothesWeb){
        adminService.createClothes(clothesWeb);
    }

    @PostMapping("reg")
    public void newAdmin(@RequestBody @Valid UserWeb userWeb){
        adminService.createAdmin(userWeb);
    }
}
