package bridge.utils;

public interface ExceptionConstants {
    enum BridgeDirectionException {
        INVALID_DIRECTION_NUMBER("위아래 두 칸으로 이루어진 다리를 생성할 때 [0, 1]중 하나의 값으로만 위/아래를 정해야 합니다."),
        INVALID_DIRECTION_COMMAND("사용자가 이동할 수 있는 방향은 [U, D]중 하나여야 합니다."),
        ;

        public final String message;

        BridgeDirectionException(final String message) {
            this.message = message;
        }
    }

    enum GameProcessDecisionCommandException {
        INVALID_PROCESS_DECISION_COMMAND("게임 재시작, 게임 종료에 대해서 [R, Q] 커맨드만 입력할 수 있습니다."),
        ;

        public final String message;

        GameProcessDecisionCommandException(final String message) {
            this.message = message;
        }
    }
}
