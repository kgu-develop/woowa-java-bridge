package bridge.utils;

public interface ExceptionMessage {
    
    String ERROR = "[ERROR] ";
    
    enum Input_Exception {
        INVALID_BRIDGE_RANGE_EXCEPTION("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
        INVALID_INPUT_SQUARE_EXCEPTION("윗 칸은 [U], 아래 칸은 [D]를 눌러주세요."),
        INVALID_INPUT_RESTART_STATUS_EXCEPTION("재시작 [R], 종료 [Q]를 눌러주세요."),
        HAS_WHITESPACE_EXCEPTION("공백을 입력할 수 없습니다."),
        IS_NOT_NUMERIC_EXCEPTION("정수만 입력 가능합니다.");
        
        private final String message;
    
        Input_Exception(String message) {
            this.message = message;
        }
    
        public String getMessage() {
            return ERROR + message;
        }
    }
}
