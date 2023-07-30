package bridge.model.bridge;

import bridge.utils.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static bridge.utils.ExceptionMessage.Input_Exception.INVALID_BRIDGE_RANGE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    @DisplayName("범위에 맞지 않은 다리 길이를 입력하지 않으면 예외가 발생한다.")
    void throwException_NotInRangeBridgeSize(int size) {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        
        // then
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BRIDGE_RANGE_EXCEPTION.getMessage());
    }
    
    @Test
    @DisplayName("다리 길이를 입력받아 다리를 생성한다.")
    void makeBridge() {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int size = 3;
    
        // when
        List<String> bridge = bridgeMaker.makeBridge(size);
    
        // then
        assertThat(bridge.size()).isEqualTo(size);
    }
}