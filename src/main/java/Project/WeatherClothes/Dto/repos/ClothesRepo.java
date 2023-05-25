package Project.WeatherClothes.Dto.repos;

import Project.WeatherClothes.Dto.ClothesDto.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepo extends JpaRepository<Clothes, Integer> {

    @Query("Select nameClothes FROM Clothes WHERE (sex = ?1 AND temp_c >= ?2 - 5 AND temp_c <= ?2 + 5 AND wind_m >= ?3 - 3.0 AND wind_m <= ?3 + 3.0)")
    List<String> getClothesDb(String sex, int temp_c, double wind_m);
}
