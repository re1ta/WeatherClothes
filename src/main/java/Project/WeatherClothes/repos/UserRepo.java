package Project.WeatherClothes.repos;

import Project.WeatherClothes.Dto.Registration.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findById(String id);
}
