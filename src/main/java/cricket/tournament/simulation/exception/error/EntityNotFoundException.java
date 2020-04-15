package cricket.tournament.simulation.exception.error;

import cricket.tournament.simulation.enums.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class entity){
        super(EntityNotFoundException.generateMessage(entity.getSimpleName()));
    }

    public static String generateMessage(String entity){
        return entity+ " " + ErrorCode.NOT_FOUND.getErrorMessage();
    }
}
