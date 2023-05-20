package Project.WeatherClothes.Service;

import Project.WeatherClothes.Dto.Registration.Role;
import Project.WeatherClothes.Dto.Registration.User;
import Project.WeatherClothes.Dto.Registration.UserWeb;
import Project.WeatherClothes.Event.impl.EventPublisher;
import Project.WeatherClothes.Service.details.UserInfoDetails;
import Project.WeatherClothes.Service.exception.HasFoundException;
import Project.WeatherClothes.Service.exception.NotFoundException;
import Project.WeatherClothes.Service.impl.UserAddtion;
import Project.WeatherClothes.Dto.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService, UserAddtion {

    private final UserRepo userRepo;

    @Qualifier("regEvent")
    private final EventPublisher regEvent;


    @Transactional
    @Override
    public void createUser(UserWeb userWeb){
        regEvent.PublishEvent();
        var userCheck = userRepo.findByUsername(userWeb.getUsername());
        if (!userCheck.isEmpty()){
            new HasFoundException("Пользователь с таким именем уже есть!");
        }
        User user = new User();
        user.setUsername(userWeb.getUsername());
        user.setPassword(userWeb.getPassword());
        if(userWeb.getSex().equals("м")){user.setSex(true);}
        else{user.setSex(false);}
        user.setRoles(List.of(Role.USER));
        userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userInfo = userRepo.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User with username %s not found", username));

        return new UserInfoDetails(userInfo);
    }

    public Optional<User> getUserByPrincipal(Principal principal) {
        return userRepo.findByUsername(principal.getName());
    }
}
