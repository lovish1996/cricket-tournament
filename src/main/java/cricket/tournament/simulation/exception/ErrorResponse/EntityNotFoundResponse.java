package cricket.tournament.simulation.exception.ErrorResponse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EntityNotFoundResponse extends BaseErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String error;

    @JsonCreator
    public EntityNotFoundResponse(@JsonProperty("timestamp") LocalDateTime timestamp,
                          @JsonProperty("status") int status,
                          @JsonProperty("error") String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }
}
