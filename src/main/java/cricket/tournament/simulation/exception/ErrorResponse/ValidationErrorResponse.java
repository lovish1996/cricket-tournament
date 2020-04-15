package cricket.tournament.simulation.exception.ErrorResponse;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ValidationErrorResponse extends SubErrorResponse {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ValidationErrorResponse(String object, String message){
        this.object = object;
        this.message = message;
    }

}
