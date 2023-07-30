package bridge.model;

import java.util.Arrays;

import static bridge.utils.ExceptionMessage.Input_Exception.INVALID_INPUT_RESTART_STATUS_EXCEPTION;

public enum RestartStatus {
    RESTART("R"),
    QUIT("Q");
    
    private static final String QUIT_SIGN = "Q";
    private static final String RESTART_SIGN = "R";
    private final String signal;
    
    RestartStatus(String signal) {
        this.signal = signal;
    }
    
    public static RestartStatus getRestartStatusBy(String signal) {
        validateCharacter(signal);
        
        return Arrays.stream(values())
                .filter(RestartStatus -> RestartStatus.signal.equals(signal))
                .findFirst()
                .orElseGet(() -> null);
    }
    
    private static void validateCharacter(String signal) {
        if (isInvalidCharacter(signal)) {
            throw new IllegalArgumentException(INVALID_INPUT_RESTART_STATUS_EXCEPTION.getMessage());
        }
    }
    
    private static boolean isInvalidCharacter(String signal) {
        return !signal.equals(RESTART_SIGN) && !signal.equals(QUIT_SIGN);
    }
}
