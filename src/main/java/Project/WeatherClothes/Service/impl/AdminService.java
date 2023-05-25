package Project.WeatherClothes.Service.impl;

import Project.WeatherClothes.Dto.ClothesDto.Clothes;
import Project.WeatherClothes.Dto.ClothesDto.ClothesWeb;
import Project.WeatherClothes.Dto.Registration.Role;
import Project.WeatherClothes.Dto.Registration.Sex;
import Project.WeatherClothes.Dto.Registration.User;
import Project.WeatherClothes.Dto.Registration.UserWeb;
import Project.WeatherClothes.Dto.repos.ClothesRepo;
import Project.WeatherClothes.Dto.repos.UserRepo;
import Project.WeatherClothes.Event.EventPublisher;
import Project.WeatherClothes.Service.AdminAddtion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AdminService implements AdminAddtion {

    private final UserRepo userRepo;

    private final ClothesRepo clothesRepo;

    @Qualifier("regAdmin")
    private final EventPublisher regAdmin;

    @Qualifier("clothesEvent")
    private final EventPublisher clothesEvent;

    @Override
    @Transactional
    public void createAdmin(UserWeb userWeb) {
        regAdmin.publishEvent();
        User user = new User();
        user.setUsername(userWeb.getUsername());
        user.setPassword(userWeb.getPassword());
        if(userWeb.getSex().equals("м")){user.setSex(Collections.singleton(Sex.MAN));}
        else {user.setSex(Collections.singleton(Sex.WOMAN));}
        user.setRoles(Collections.singleton(Role.ADMIN));
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void createClothes(ClothesWeb clothesWeb) {
        clothesEvent.publishEvent();
        Clothes clothes = new Clothes(clothesWeb);
        clothesRepo.save(clothes);
    }
}
