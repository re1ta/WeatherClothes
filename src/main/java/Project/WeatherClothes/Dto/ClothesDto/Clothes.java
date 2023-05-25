package Project.WeatherClothes.Dto.ClothesDto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameClothes;

    private int temp_c;

    private double wind_m;

    private String sex;

    public Clothes(ClothesWeb clothesWeb){
        this.nameClothes = clothesWeb.getNameClothes();
        this.temp_c = clothesWeb.getTemp_c();
        this.wind_m = clothesWeb.getWind_m();
        this.sex = clothesWeb.getSex();
    }
}
