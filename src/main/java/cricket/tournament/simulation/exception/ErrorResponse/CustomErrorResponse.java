package cricket.tournament.simulation.exception.ErrorResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomErrorResponse extends BaseErrorResponse {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<SubErrorResponse> subErrors;

    public CustomErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public CustomErrorResponse(HttpStatus status) {
        this();
        this.status = status;
    }

    public CustomErrorResponse(HttpStatus status, String message) {
        this(status);
        this.message = message;
    }

    public CustomErrorResponse(HttpStatus status, Throwable ex) {
        this(status);
        this.message = "Unexpected Error";
        this.debugMessage = ex.getLocalizedMessage();
    }


    public CustomErrorResponse(HttpStatus status, String message, Throwable ex) {
        this(status, message);
        this.debugMessage = ex.getLocalizedMessage();
    }

    public void addSubError(SubErrorResponse subErrorResponse) {
        if (this.subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.add(subErrorResponse);
    }

    public void addValidationError(String object, String message) {
        addSubError(new ValidationErrorResponse(object, message));
    }

    public void addValidationError(String object, String field, Object rejectedValue, String message) {
        addSubError(new ValidationErrorResponse(object, field, rejectedValue, message));
    }

    public void addValidationError(FieldError fieldError) {
        this.addValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.getDefaultMessage());
    }

    public void addValidationError(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

}
