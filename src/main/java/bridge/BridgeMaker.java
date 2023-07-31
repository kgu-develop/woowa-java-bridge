package bridge;

import bridge.model.bridge.BridgeDirection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bridge.utils.BridgeConstants.MAX_VALUE;
import static bridge.utils.BridgeConstants.MIN_VALUE;
import static bridge.utils.ExceptionConstants.BridgeMakerException.BRIDGE_SIZE_IS_OUT_OF_RANGE;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(final BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(final int size) {
        validateBridgeSize(size);

        return IntStream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .mapToObj(BridgeDirection::fromNumber)
                .map(BridgeDirection::getCommand)
                .collect(Collectors.toList());
    }

    private void validateBridgeSize(final int size) {
        if (isOutOfRange(size)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_IS_OUT_OF_RANGE.message);
        }
    }

    private boolean isOutOfRange(final int size) {
        return size < MIN_VALUE || size > MAX_VALUE;
    }
}
