package Project.WeatherClothes.Dto.repos;

import Project.WeatherClothes.Dto.Registration.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
