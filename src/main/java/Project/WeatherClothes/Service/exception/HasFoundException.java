package Project.WeatherClothes.Service.exception;

public class HasFoundException extends RuntimeException {

    public HasFoundException(String message) {
        super(String.format(message));
    }
}
