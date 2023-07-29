package bridge.model.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.model.game.GameRoundStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeLineTest {
    @Test
    @DisplayName("BridgeLine을 생성하고 GameRoundStatus 결과에 따라 각 칸을 추가하면서 채운다")
    void construct() {
        final BridgeLine bridgeLine = BridgeLine.create();
        String result = String.format("[ %s ]", "");
        assertThat(bridgeLine.toString()).isEqualTo(result);

        // add success
        bridgeLine.addLine(ROUND_SUCCESS);
        result = String.format("[ %s ]", ROUND_SUCCESS.getValue());
        assertThat(bridgeLine.toString()).isEqualTo(result);

        // add fail
        bridgeLine.addLine(ROUND_FAIL);
        result = String.format("[ %s | %s ]", ROUND_SUCCESS.getValue(), ROUND_FAIL.getValue());
        assertThat(bridgeLine.toString()).isEqualTo(result);

        // add none
        bridgeLine.addLine(NONE);
        result = String.format("[ %s | %s | %s ]", ROUND_SUCCESS.getValue(), ROUND_FAIL.getValue(), NONE.getValue());
        assertThat(bridgeLine.toString()).isEqualTo(result);
    }
}
