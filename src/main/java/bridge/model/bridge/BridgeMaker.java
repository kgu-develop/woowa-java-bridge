package bridge.model.bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bridge.utils.ExceptionMessage.Input_Exception.INVALID_BRIDGE_RANGE_EXCEPTION;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(final int size) {
        validateBridgeRange(size);
        
        return IntStream.range(0, size)
                .mapToObj(i -> Direct.getDirectBy(bridgeNumberGenerator.generate()))
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
    
    private void validateBridgeRange(final int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_BRIDGE_RANGE_EXCEPTION.getMessage());
        }
    }
}
