package Project.WeatherClothes.Controllers;

import Project.WeatherClothes.Aspect.anno.Counter;
import Project.WeatherClothes.Dto.Registration.UserWeb;
import Project.WeatherClothes.Service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class AuthControllers {

    private final UserService userService;

    private final UserDetailsService userDetailsService;

    @Counter
    @PostMapping("registration")
    public void registrationPage(@RequestBody @Valid UserWeb userWeb){
        userService.createUser(userWeb);
    }

    @GetMapping("login")
    public void loginPage(Principal principal){
        userDetailsService.loadUserByUsername(principal.getName());
    }

    @PostMapping("logout")
    public void logoutPage() {
    }
}
