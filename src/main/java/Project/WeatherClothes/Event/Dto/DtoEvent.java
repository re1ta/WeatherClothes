package Project.WeatherClothes.Event.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
public class DtoEvent extends ApplicationEvent {

    private String message;
    public DtoEvent(Object source) {
        super(source);
    }


}
