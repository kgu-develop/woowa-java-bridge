package bridge.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.utils.ExceptionConstants.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;
import static bridge.utils.ExceptionConstants.InputException.INVALID_MOVE_COMMAND;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MoveCommandValidatorTest {
    private static final MoveCommandValidator MOVE_COMMAND_VALIDATOR = new MoveCommandValidator();

    @Test
    @DisplayName("입력한 이동 칸에 공백이 존재하면 예외가 발생한다")
    void throwExceptionByInputHasSpace() {
        assertThatThrownBy(() -> MOVE_COMMAND_VALIDATOR.validate("U "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_NOT_CONTAINS_SPACE.message);
    }

    @Test
    @DisplayName("입력한 이동 칸이 [U, D]중 하나가 아니면 예외가 발생한다")
    void throwExceptionByMoveCommandIsInvalid() {
        assertThatThrownBy(() -> MOVE_COMMAND_VALIDATOR.validate("h"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_MOVE_COMMAND.message);
    }

    @Test
    @DisplayName("입력한 이동 칸 검증에 성공한다")
    void success() {
        assertAll(
                () -> assertDoesNotThrow(() -> MOVE_COMMAND_VALIDATOR.validate("U")),
                () -> assertDoesNotThrow(() -> MOVE_COMMAND_VALIDATOR.validate("D"))
        );
    }
}
