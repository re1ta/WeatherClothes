package Project.WeatherClothes.Event.impl;

import Project.WeatherClothes.Event.Dto.DtoEvent;
import Project.WeatherClothes.Event.EventPublisher;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service("regAdmin")
@Log4j2
public class RegAdminService implements EventPublisher {

    private DtoEvent dtoEvent = new DtoEvent(this);

    @Override
    @EventListener(classes = {DtoEvent.class})
    public void publishEvent() {
        dtoEvent.setMessage("Появился новый админ!");
        log.info(dtoEvent.getMessage());
    }
}