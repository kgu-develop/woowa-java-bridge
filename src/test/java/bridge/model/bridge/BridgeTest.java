package bridge.model.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.model.bridge.BridgeDirection.DOWN;
import static bridge.model.bridge.BridgeDirection.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BridgeTest {
    @Test
    @DisplayName("Bridge를 생성한다")
    void construct() {
        // given
        final List<String> element = List.of("U", "D", "D", "U");

        // when
        final Bridge bridge = new Bridge(element);

        // then
        assertAll(
                () -> assertThat(bridge.getBridge()).hasSize(4),
                () -> assertThat(bridge.getBridgeDirectionByIndex(0)).isEqualTo(UP),
                () -> assertThat(bridge.getBridgeDirectionByIndex(1)).isEqualTo(DOWN),
                () -> assertThat(bridge.getBridgeDirectionByIndex(2)).isEqualTo(DOWN),
                () -> assertThat(bridge.getBridgeDirectionByIndex(3)).isEqualTo(UP),
                () -> assertThat(bridge.isEndOfBridge(0)).isFalse(),
                () -> assertThat(bridge.isEndOfBridge(1)).isFalse(),
                () -> assertThat(bridge.isEndOfBridge(2)).isFalse(),
                () -> assertThat(bridge.isEndOfBridge(3)).isTrue()
        );
    }
}
