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

    enum InputException {
        INPUT_MUST_NOT_CONTAINS_SPACE("공백없이 입력해주세요."),
        INPUT_MUST_BE_NUMERIC("숫자를 입력해주세요."),
        INVALID_MOVE_COMMAND("U, D중 하나를 입력해주세요"),
        INVALID_GAME_PROCESS_COMMAND("R, Q중 하나를 입력해주세요"),
        ;

        public final String message;

        InputException(final String message) {
            this.message = message;
        }
    }
}
