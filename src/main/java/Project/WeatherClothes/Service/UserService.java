package Project.WeatherClothes.Service;

import Project.WeatherClothes.Dto.Registration.Role;
import Project.WeatherClothes.Dto.Registration.User;
import Project.WeatherClothes.Dto.Registration.UserWeb;
import Project.WeatherClothes.impl.UserAddtion;
import Project.WeatherClothes.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserAddtion {

    private final UserRepo userRepo;

    @Override
    public void createUser(UserWeb userWeb){
        User user = new User();
        user.setUsername(userWeb.getUsername());
        user.setPassword(userWeb.getPassword());
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userRepo.save(user);
    }
}
