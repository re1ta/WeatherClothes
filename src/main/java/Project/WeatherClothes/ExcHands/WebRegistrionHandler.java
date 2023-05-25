package Project.WeatherClothes.ExcHands;

import Project.WeatherClothes.Dto.ExcDto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class WebRegistrionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<List<ErrorMessage>> handleException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ErrorMessage> arrayErrors = new ArrayList<>();
        fieldErrors.stream().forEach(x -> arrayErrors.add(new ErrorMessage(x.getField(), x.getDefaultMessage())));
        return status(HttpStatus.BAD_REQUEST).body(arrayErrors);
    }
}
