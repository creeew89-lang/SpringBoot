
package tra.codline.almuiayed.inventory.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("status", HttpStatus.BAD_REQUEST.value());

        List<String> errors = ex.getBindingResult().getFieldErrors()
                                .stream()
                                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                                .collect(toList());
        map.put("errors", errors);
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Map<String, Object>> buildResponse(String message, HttpStatus status) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("status", status.value());
        map.put("message", message);
        return new ResponseEntity<>(map, status);
    }
}