package bridge.model.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.common.BridgeFixture.INIT_BRIDGE_LINE;
import static bridge.common.BridgeFixture.createBridgeLine;
import static bridge.model.game.GameRoundStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BridgeLineTest {
    @Test
    @DisplayName("BridgeLine을 생성하고 GameRoundStatus 결과에 따라 각 칸을 추가하면서 채운다")
    void construct() {
        final BridgeLine bridgeLine = BridgeLine.create();
        assertThat(bridgeLine.toString()).isEqualTo(INIT_BRIDGE_LINE);

        // add success
        bridgeLine.addLine(ROUND_SUCCESS);
        assertAll(
                () -> assertThat(bridgeLine.getLength()).isEqualTo(1),
                () -> assertThat(bridgeLine.toString())
                        .isEqualTo(createBridgeLine("[ %s ]", List.of(ROUND_SUCCESS)))
        );

        // add fail
        bridgeLine.addLine(ROUND_FAIL);
        assertAll(
                () -> assertThat(bridgeLine.getLength()).isEqualTo(2),
                () -> assertThat(bridgeLine.toString())
                        .isEqualTo(createBridgeLine("[ %s | %s ]", List.of(ROUND_SUCCESS, ROUND_FAIL)))
        );

        // add none
        bridgeLine.addLine(ROUND_NONE);
        assertAll(
                () -> assertThat(bridgeLine.getLength()).isEqualTo(3),
                () -> assertThat(bridgeLine.toString())
                        .isEqualTo(createBridgeLine("[ %s | %s | %s ]", List.of(ROUND_SUCCESS, ROUND_FAIL, ROUND_NONE)))
        );
    }
}
