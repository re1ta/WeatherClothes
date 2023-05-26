package Project.WeatherClothes.Dto.ClothesDto;

import Project.WeatherClothes.Dto.Registration.Sex;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameClothes;

    private int temp_min;

    private int temp_max;

    private double wind_min;

    private double wind_max;

    @ElementCollection(targetClass = Sex.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "clothes_sex",
            joinColumns = @JoinColumn(name = "clothes_id"))
    @Enumerated(EnumType.STRING)
    private Set<Sex> sex;

    public Clothes(ClothesWeb clothesWeb){
        this.nameClothes = clothesWeb.getNameClothes();
        this.temp_min = clothesWeb.getTemp_min();
        this.temp_max = clothesWeb.getTemp_max();
        this.wind_min = clothesWeb.getWind_min();
        this.wind_max = clothesWeb.getWind_max();
        if (clothesWeb.getSex().equals("м")){
            this.sex = Collections.singleton(Sex.MAN);
        }
        else if (clothesWeb.getSex().equals("ж")){
            this.sex = Collections.singleton(Sex.WOMAN);
        }
        else { this.sex = Set.of(Sex.MAN, Sex.WOMAN);
        }
    }
}
