package Project.WeatherClothes.Service.job;

import Project.WeatherClothes.Aspect.CityAspect;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("job")
@Log4j2
@RequiredArgsConstructor
public class CounterInfoJob {

    private final CityAspect cityAspect;

    // я хз почему, но через крону у меня не работает джоб, так что
    // я сделал через fixedDelay(время 1 день)
    @Scheduled(fixedDelay = 86400000)
    public void countReg(){
        log.info(cityAspect.getCount());
        cityAspect.setCount(0);
    }
}
