package Project.WeatherClothes.Controllers;

import Project.WeatherClothes.Dto.Registration.UserWeb;
import Project.WeatherClothes.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthControllers {

    private final UserService userService;

    @PostMapping("registration")
    public void registrationPage(@RequestBody @Valid UserWeb userWeb){
        userService.createUser(userWeb);
    }
}
