package bridge.model;

import java.util.Arrays;

public enum RestartStatus {
    RESTART("R"),
    QUIT("Q");
    
    public final String signal;
    
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
            throw new IllegalArgumentException("재시작 [R], 종료 [Q]를 눌러주세요");
        }
    }
    
    private static boolean isInvalidCharacter(String signal) {
        return !signal.equals("R") && !signal.equals("Q");
    }
}
