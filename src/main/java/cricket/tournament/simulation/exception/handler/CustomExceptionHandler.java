package cricket.tournament.simulation.exception.handler;

import cricket.tournament.simulation.enums.ErrorCode;
import cricket.tournament.simulation.exception.ErrorResponse.CustomErrorResponse;
import cricket.tournament.simulation.exception.error.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ErrorCode.MISSING_REQUEST_ARGUMENT.getErrorMessage() + " : " + ex.getParameterName();
        return buildErrorResponse(new CustomErrorResponse(HttpStatus.BAD_REQUEST,error));
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST);
      errorResponse.setMessage(ErrorCode.VALIDATION_ERROR.getErrorMessage());
      errorResponse.addValidationError(ex.getBindingResult().getFieldErrors());
      return buildErrorResponse(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST);
        return buildErrorResponse(errorResponse);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex){
        return buildErrorResponse(new CustomErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        if(ex.getCause() instanceof ConstraintViolationException){
            return buildErrorResponse(new CustomErrorResponse(HttpStatus.CONFLICT, ErrorCode.DB_CONSTRAINT_VIOLATION.getErrorMessage(), ex.getCause()));
        }
        return buildErrorResponse(new CustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex));
    }

    public ResponseEntity<Object> buildErrorResponse(CustomErrorResponse errorResponse){
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

}
