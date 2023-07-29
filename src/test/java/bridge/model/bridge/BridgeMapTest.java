package bridge.model.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.common.BridgeFixture.INIT_BRIDGE_MAP;
import static bridge.common.BridgeFixture.createBridgeMap;
import static bridge.model.bridge.BridgeDirection.DOWN;
import static bridge.model.bridge.BridgeDirection.UP;
import static bridge.model.game.GameRoundStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapTest {
    @Test
    @DisplayName("BridgeMap을 생성하고 게임 진행에 따른 Map 현황을 확인한다")
    void construct() {
        final BridgeMap bridgeMap = BridgeMap.init();
        assertThat(bridgeMap.toString()).isEqualTo(INIT_BRIDGE_MAP);

        // Direction[U] -> Success
        bridgeMap.updateMap(UP, ROUND_SUCCESS);
        assertThat(bridgeMap.toString())
                .isEqualTo(
                        createBridgeMap(
                                "[ %s ]", List.of(ROUND_SUCCESS),
                                "[ %s ]", List.of(ROUND_NONE)
                        )
                );

        // Direction[D] -> Success
        bridgeMap.updateMap(DOWN, ROUND_SUCCESS);
        assertThat(bridgeMap.toString())
                .isEqualTo(
                        createBridgeMap(
                                "[ %s | %s ]", List.of(ROUND_SUCCESS, ROUND_NONE),
                                "[ %s | %s ]", List.of(ROUND_NONE, ROUND_SUCCESS)
                        )
                );

        // Direction[D] -> Success
        bridgeMap.updateMap(DOWN, ROUND_SUCCESS);
        assertThat(bridgeMap.toString())
                .isEqualTo(
                        createBridgeMap(
                                "[ %s | %s | %s ]", List.of(ROUND_SUCCESS, ROUND_NONE, ROUND_NONE),
                                "[ %s | %s | %s ]", List.of(ROUND_NONE, ROUND_SUCCESS, ROUND_SUCCESS)
                        )
                );

        // Direction[U] -> Fail
        bridgeMap.updateMap(UP, ROUND_FAIL);
        assertThat(bridgeMap.toString())
                .isEqualTo(
                        createBridgeMap(
                                "[ %s | %s | %s | %s ]", List.of(ROUND_SUCCESS, ROUND_NONE, ROUND_NONE, ROUND_FAIL),
                                "[ %s | %s | %s | %s ]", List.of(ROUND_NONE, ROUND_SUCCESS, ROUND_SUCCESS, ROUND_NONE)
                        )
                );
    }
}
