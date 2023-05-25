package Project.WeatherClothes.Dto.Registration;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

import static Project.WeatherClothes.Config.MainConfig.passwordEncoder;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique=true)
    private String username;

    private String password;

    @ElementCollection(targetClass = Sex.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_sex",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Sex> sex;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public void setPassword(String password) {
        this.password = passwordEncoder().encode(password);
    }
}
