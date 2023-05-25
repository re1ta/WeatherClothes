package Project.WeatherClothes.Dto.Registration.Anno;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {})
@Size(min = 5)
@NotBlank
@Documented
public @interface RegistrationConditions {
    String message() default "Неправильно заполнено поле(-я)! Соблюдайте все условия!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
