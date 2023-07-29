package bridge.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.utils.ExceptionConstants.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;
import static bridge.utils.ExceptionConstants.InputException.INVALID_GAME_PROCESS_COMMAND;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GameProcessCommandValidatorTest {
    private static final GameProcessCommandValidator GAME_PROCESS_COMMAND_VALIDATOR = new GameProcessCommandValidator();

    @Test
    @DisplayName("입력한 게임 재시작/종료 커맨드에 공백이 존재하면 예외가 발생한다")
    void throwExceptionByInputHasSpace() {
        assertThatThrownBy(() -> GAME_PROCESS_COMMAND_VALIDATOR.validate("R "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_NOT_CONTAINS_SPACE.message);
    }

    @Test
    @DisplayName("입력한 게임 재시작/종료 커맨드가 [R, Q]중 하나가 아니면 예외가 발생한다")
    void throwExceptionByGameProcessCommandIsInvalid() {
        assertThatThrownBy(() -> GAME_PROCESS_COMMAND_VALIDATOR.validate("h"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_GAME_PROCESS_COMMAND.message);
    }

    @Test
    @DisplayName("입력한 게임 재시작/종료 커맨드 검증에 성공한다")
    void success() {
        assertAll(
                () -> assertDoesNotThrow(() -> GAME_PROCESS_COMMAND_VALIDATOR.validate("R")),
                () -> assertDoesNotThrow(() -> GAME_PROCESS_COMMAND_VALIDATOR.validate("Q"))
        );
    }
}
