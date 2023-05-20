package Project.WeatherClothes.Aspect;

import lombok.Data;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("city")
@Log4j2
@Data
public class CityAspect {

    private int count;

    @Pointcut("@annotation(Project.WeatherClothes.Aspect.anno.Counter)")
    public void pointcutCount() {
    }

    @Before("pointcutCount()")
    public void counterUsersPerDay() {
        count++;
    }
}
