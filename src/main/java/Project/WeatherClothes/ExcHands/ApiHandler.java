package Project.WeatherClothes.ExcHands;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class ApiHandler {

    @ExceptionHandler(value = UnrecognizedPropertyException.class)
    private ResponseEntity<String> handlePSQLException(UnrecognizedPropertyException ex) {
        return status(HttpStatus.BAD_REQUEST).body("Не существует такого города!");
    }
}
