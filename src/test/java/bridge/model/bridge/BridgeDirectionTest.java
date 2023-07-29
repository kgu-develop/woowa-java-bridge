package bridge.model.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static bridge.model.bridge.BridgeDirection.DOWN;
import static bridge.model.bridge.BridgeDirection.UP;
import static bridge.utils.ExceptionConstants.BridgeDirectionException.INVALID_DIRECTION_COMMAND;
import static bridge.utils.ExceptionConstants.BridgeDirectionException.INVALID_DIRECTION_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BridgeDirectionTest {
    @Nested
    @DisplayName("숫자로 BridgeDirection 조회")
    class FromNumber {
        @Test
        @DisplayName("[0, 1]이 아닌 다른 숫자로 BridgeDirection을 조회하면 예외가 발생한다")
        void throwExceptionByInvalidDirectionNumber() {
            assertAll(
                    () -> assertThatThrownBy(() -> BridgeDirection.fromNumber(-1))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_DIRECTION_NUMBER.message),
                    () -> assertThatThrownBy(() -> BridgeDirection.fromNumber(-2))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_DIRECTION_NUMBER.message)
            );
        }

        @Test
        @DisplayName("정상적인 숫자로 BridgeDirection을 조회한다")
        void success() {
            assertAll(
                    () -> assertThat(BridgeDirection.fromNumber(0)).isEqualTo(UP),
                    () -> assertThat(BridgeDirection.fromNumber(1)).isEqualTo(DOWN)
            );
        }
    }

    @Nested
    @DisplayName("Command로 BridgeDirection 조회")
    class FromCommand {
        @Test
        @DisplayName("[U, D]가 아닌 다른 Command로 BridgeDirection을 조회하면 예외가 발생한다")
        void throwExceptionByInvalidDirectionCommand() {
            assertAll(
                    () -> assertThatThrownBy(() -> BridgeDirection.fromCommand("u"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_DIRECTION_COMMAND.message),
                    () -> assertThatThrownBy(() -> BridgeDirection.fromCommand("d"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_DIRECTION_COMMAND.message),
                    () -> assertThatThrownBy(() -> BridgeDirection.fromCommand("h"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_DIRECTION_COMMAND.message)
            );
        }

        @Test
        @DisplayName("정상적인 Command로 BridgeDirection을 조회한다")
        void success() {
            assertAll(
                    () -> assertThat(BridgeDirection.fromCommand("U")).isEqualTo(UP),
                    () -> assertThat(BridgeDirection.fromCommand("D")).isEqualTo(DOWN)
            );
        }
    }
}
