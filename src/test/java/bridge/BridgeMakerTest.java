package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static bridge.utils.ExceptionConstants.BridgeMakerException.BRIDGE_SIZE_IS_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BridgeMakerTest {
    private static final BridgeMaker BRIDGE_MAKER = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 21})
    @DisplayName("길이가 3..20 범위가 아니면 다리를 생성할 수 없다")
    void throwExceptionByOutOfRange(final int size) {
        assertThatThrownBy(() -> BRIDGE_MAKER.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BRIDGE_SIZE_IS_OUT_OF_RANGE.message);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    @DisplayName("Size 길이 만큼의 다리를 생성한다")
    void construct(final int size) {
        // when
        final List<String> bridge = BRIDGE_MAKER.makeBridge(size);

        // then
        assertAll(
                () -> assertThat(bridge).hasSize(size),
                () -> assertThat(bridge).allMatch(value -> value.equals("U") || value.equals("D"))
        );
    }
}
