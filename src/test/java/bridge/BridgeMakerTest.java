package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BridgeMakerTest {
    @Test
    @DisplayName("Size 길이 만큼의 다리를 생성한다")
    void construct() {
        // given
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when
        final List<String> bridge = bridgeMaker.makeBridge(5);

        // then
        assertAll(
                () -> assertThat(bridge).hasSize(5),
                () -> assertThat(bridge).allMatch(value -> value.equals("U") || value.equals("D"))
        );
    }
}
