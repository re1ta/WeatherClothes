package Project.WeatherClothes.Aspect;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("time")
@Log4j2
public class TimeProcessAspect {

    @Pointcut("@annotation(Project.WeatherClothes.Aspect.anno.Timer)")
    public void pointcutExample() {
    }

    @SneakyThrows
    @Around("pointcutExample()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {

        long start = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            var result = (Float.valueOf(System.nanoTime()) - start) / 1000000000;
            log.info("Api завершилось за (s): {}", result);
        }

    }
}
