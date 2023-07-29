package bridge.model.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.model.bridge.BridgeDirection.DOWN;
import static bridge.model.bridge.BridgeDirection.UP;
import static bridge.model.game.GameRoundStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapTest {
    @Test
    @DisplayName("BridgeMap을 생성하고 게임 진행에 따른 Map 현황을 확인한다")
    void construct() {
        final BridgeMap bridgeMap = BridgeMap.init();
        StringBuilder result = new StringBuilder()
                .append(String.format("[ %s ]", ""))
                .append("\n")
                .append(String.format("[ %s ]", ""));
        assertThat(bridgeMap.toString()).isEqualTo(result.toString());

        // Direction[U] -> Success
        bridgeMap.updateMap(UP, ROUND_SUCCESS);
        result = new StringBuilder()
                .append(String.format("[ %s ]", ROUND_SUCCESS.getValue()))
                .append("\n")
                .append(String.format("[ %s ]", NONE.getValue()));
        assertThat(bridgeMap.toString()).isEqualTo(result.toString());

        // Direction[D] -> Success
        bridgeMap.updateMap(DOWN, ROUND_SUCCESS);
        result = new StringBuilder()
                .append(String.format("[ %s | %s ]", ROUND_SUCCESS.getValue(), NONE.getValue()))
                .append("\n")
                .append(String.format("[ %s | %s ]", NONE.getValue(), ROUND_SUCCESS.getValue()));
        assertThat(bridgeMap.toString()).isEqualTo(result.toString());

        // Direction[D] -> Success
        bridgeMap.updateMap(DOWN, ROUND_SUCCESS);
        result = new StringBuilder()
                .append(String.format("[ %s | %s | %s ]", ROUND_SUCCESS.getValue(), NONE.getValue(), NONE.getValue()))
                .append("\n")
                .append(String.format("[ %s | %s | %s ]", NONE.getValue(), ROUND_SUCCESS.getValue(), ROUND_SUCCESS.getValue()));
        assertThat(bridgeMap.toString()).isEqualTo(result.toString());

        // Direction[U] -> Fail
        bridgeMap.updateMap(UP, ROUND_FAIL);
        result = new StringBuilder()
                .append(String.format("[ %s | %s | %s | %s ]", ROUND_SUCCESS.getValue(), NONE.getValue(), NONE.getValue(), ROUND_FAIL.getValue()))
                .append("\n")
                .append(String.format("[ %s | %s | %s | %s ]", NONE.getValue(), ROUND_SUCCESS.getValue(), ROUND_SUCCESS.getValue(), NONE.getValue()));
        assertThat(bridgeMap.toString()).isEqualTo(result.toString());
    }
}
