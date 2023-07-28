package bridge.model.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
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