package Project.WeatherClothes.Dto.repos;

import Project.WeatherClothes.Dto.ClothesDto.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepo extends JpaRepository<Clothes, Integer> {

    @Query(value = "SELECT name_clothes FROM Clothes JOIN Clothes_sex ON Clothes.id = Clothes_sex.clothes_id " +
           "WHERE (sex = ?1 AND temp_min <= ?2 AND temp_max >= ?2 AND wind_min <= ?3 AND wind_max >= ?3)", nativeQuery = true)
    List<String> getClothesDb(String sex, int temp_c, double wind_m);
}
