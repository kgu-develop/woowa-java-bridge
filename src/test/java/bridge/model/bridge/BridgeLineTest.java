package bridge.model.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.model.game.GameRoundStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeLineTest {
    @Test
    @DisplayName("BridgeLine을 생성하고 GameRoundStatus 결과에 따라 각 칸을 추가하면서 채운다")
    void construct() {
        String result;

        final BridgeLine bridgeLine = BridgeLine.create();
        result = String.format("[ %s ]", "");
        assertThat(bridgeLine.toString()).isEqualTo(result);

        // add success
        bridgeLine.addLine(SUCCESS);
        result = String.format("[ %s ]", SUCCESS.getValue());
        assertThat(bridgeLine.toString()).isEqualTo(result);

        // add fail
        bridgeLine.addLine(FAIL);
        result = String.format("[ %s | %s ]", SUCCESS.getValue(), FAIL.getValue());
        assertThat(bridgeLine.toString()).isEqualTo(result);

        // add none
        bridgeLine.addLine(NONE);
        result = String.format("[ %s | %s | %s ]", SUCCESS.getValue(), FAIL.getValue(), NONE.getValue());
        assertThat(bridgeLine.toString()).isEqualTo(result);
    }
}
