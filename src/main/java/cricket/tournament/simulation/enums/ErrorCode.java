package cricket.tournament.simulation.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    BAD_REQUEST(3, "Invalid Request"),
    DB_CONSTRAINT_VIOLATION(4,"Constraint Violation/Database Error"),
    INTERNAL_SERVER_ERROR(2, "Server Error"),
    MISSING_REQUEST_ARGUMENT(5,"Request Argument Missing"),
    NOT_FOUND(1, " not found for given parameters"),
    VALIDATION_ERROR(6, "Validation Error");

    private int errorCode;
    private String errorMessage;

    ErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static ErrorCode getValue(int errorCode){
        for(ErrorCode error : ErrorCode.values()){
            if(error.errorCode==errorCode){
                return error;
            }
        }
        return null;
    }

    public static ErrorCode getValue(String errorMessage){
        for(ErrorCode error : ErrorCode.values()){
            if(error.errorMessage.equalsIgnoreCase(errorMessage)){
                return error;
            }
        }
        return null;
    }

    public static String getErrorMessageFromErrorCode(int errorCode){
        for(ErrorCode error: ErrorCode.values()){
            if(error.errorCode==errorCode){
                return error.errorMessage;
            }
        }
        return null;
    }
}
