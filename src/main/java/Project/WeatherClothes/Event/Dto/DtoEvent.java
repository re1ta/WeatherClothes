package Project.WeatherClothes.Event.Dto;

import org.springframework.context.ApplicationEvent;

import org.springframework.stereotype.Component;

@Component("dtoEvent")
public class DtoEvent extends ApplicationEvent {

    private final String message = "Зарегестрирован новый пользователь!";
    public DtoEvent(Object source) {
        super(source);
    }

    public String getMessage(){
        return message;
    }
}
