package Project.WeatherClothes.Service.impl;

import Project.WeatherClothes.Dto.Registration.Role;
import Project.WeatherClothes.Dto.Registration.Sex;
import Project.WeatherClothes.Dto.Registration.User;
import Project.WeatherClothes.Dto.Registration.UserWeb;
import Project.WeatherClothes.Event.EventPublisher;
import Project.WeatherClothes.Service.UserAddtion;
import Project.WeatherClothes.Service.details.UserInfoDetails;
import Project.WeatherClothes.Service.exception.HasFoundException;
import Project.WeatherClothes.Service.exception.NotFoundException;
import Project.WeatherClothes.Dto.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService, UserAddtion {

    private final UserRepo userRepo;

    @Qualifier("regUser")
    private final EventPublisher regUser;

    @Transactional
    @Override
    public void createUser(UserWeb userWeb) {
        regUser.publishEvent();
        User user = new User();
        user.setUsername(userWeb.getUsername());
        user.setPassword(userWeb.getPassword());
        if(userWeb.getSex().equals("м")){user.setSex(Collections.singleton(Sex.MAN));}
        else {user.setSex(Collections.singleton(Sex.WOMAN));}
        user.setRoles(Collections.singleton(Role.USER));
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