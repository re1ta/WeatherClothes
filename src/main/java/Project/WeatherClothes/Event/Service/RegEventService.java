package Project.WeatherClothes.Event.Service;


import Project.WeatherClothes.Event.Dto.DtoEvent;
import Project.WeatherClothes.Event.impl.EventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service("regEvent")
@Log4j2
public class RegEventService implements EventPublisher {

    private DtoEvent dtoEvent = new DtoEvent(this);

    @Override
    @EventListener(classes = {DtoEvent.class})
    public void PublishEvent() {
        dtoEvent.setMessage("Зарегестрирован новый пользователь!");
        log.info(dtoEvent.getMessage());
    }
}
