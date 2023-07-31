package bridge.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.utils.ExceptionConstants.InputException.INPUT_MUST_BE_NUMERIC;
import static bridge.utils.ExceptionConstants.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BridgeLengthValidatorTest {
    private static final BridgeLengthValidator BRIDGE_LENGTH_VALIDATOR = new BridgeLengthValidator();

    @Test
    @DisplayName("다리 길이에 공백이 존재하면 예외가 발생한다")
    void throwExceptionByInputHasSpace() {
        assertThatThrownBy(() -> BRIDGE_LENGTH_VALIDATOR.validate("3 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_NOT_CONTAINS_SPACE.message);
    }

    @Test
    @DisplayName("다리 길이가 숫자가 아니면 예외가 발생한다")
    void throwExceptionByInputIsNotNumeric() {
        assertThatThrownBy(() -> BRIDGE_LENGTH_VALIDATOR.validate("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_BE_NUMERIC.message);
    }

    @Test
    @DisplayName("다리 길이 검증에 성공한다")
    void success() {
        assertDoesNotThrow(() -> BRIDGE_LENGTH_VALIDATOR.validate("3"));
    }
}
