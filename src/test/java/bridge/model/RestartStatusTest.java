package bridge.model;

import bridge.model.bridge.BridgeMaker;
import bridge.model.bridge.BridgeNumberGenerator;
import bridge.model.bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.utils.ExceptionMessage.Input_Exception.INVALID_BRIDGE_RANGE_EXCEPTION;
import static bridge.utils.ExceptionMessage.Input_Exception.INVALID_INPUT_RESTART_STATUS_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RestartStatusTest {
    @Test
    @DisplayName("올바르지 않은 문자를 입력하면 예외가 발생한다.")
    void throwException_InvalidCharacter() {
        // given
        String signal = "G";
        
        // then
        assertThatThrownBy(() -> RestartStatus.getRestartStatusBy(signal))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT_RESTART_STATUS_EXCEPTION.getMessage());
    }
    
    @Test
    @DisplayName("게임을 재시작한다.")
    void restart() {
        // given
        String signal = "R";
        
        // when
        RestartStatus restartStatus = RestartStatus.getRestartStatusBy(signal);
    
        // then
        assertThat(RestartStatus.RESTART).isEqualTo(restartStatus);
    }
    
    @Test
    @DisplayName("게임을 종료한다.")
    void quit() {
        // given
        String signal = "Q";
        
        // when
        RestartStatus restartStatus = RestartStatus.getRestartStatusBy(signal);
        
        // then
        assertThat(RestartStatus.QUIT).isEqualTo(restartStatus);
    }
}