package Project.WeatherClothes.Dto.Registration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Sex {

    MAN("man", "SEX_MAN"),
    WOMAN("woman", "SEX_WOMAN");

    private final String id;
    private final String sexName;
}