package cricket.tournament.simulation.exception.handler;

import cricket.tournament.simulation.exception.ErrorResponse.EntityNotFoundResponse;
import cricket.tournament.simulation.exception.error.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundResponse> handleEntityNotFound(Exception ex){
        return new ResponseEntity<>(new EntityNotFoundResponse(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),ex.getMessage()),HttpStatus.NOT_FOUND);
    }
}
