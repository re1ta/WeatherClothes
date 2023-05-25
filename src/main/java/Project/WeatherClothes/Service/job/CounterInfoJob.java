package Project.WeatherClothes.Service.job;

import Project.WeatherClothes.Aspect.UserAspect;
import Project.WeatherClothes.Service.EmailAddition;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("job")
@Log4j2
@RequiredArgsConstructor
public class CounterInfoJob {

    private final UserAspect userAspect;
    private final EmailAddition emailService;

    @Scheduled(fixedDelay = 86400000)
    public void countReg(){
        emailService.sendEmailMessage(String.valueOf(userAspect.getCount()));
        userAspect.setCount(0);
    }
}
