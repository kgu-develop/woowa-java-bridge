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
        assertThat(bridgeLine.getLine()).isEqualTo("[  ]");

        // add success
        bridgeLine.addLine(SUCCESS);
        assertThat(bridgeLine.getLine()).isEqualTo("[ O ]");

        // add fail
        bridgeLine.addLine(FAIL);
        assertThat(bridgeLine.getLine()).isEqualTo("[ O | X ]");

        // add none
        bridgeLine.addLine(NONE);
        assertThat(bridgeLine.getLine()).isEqualTo("[ O | X |   ]");
    }
}
