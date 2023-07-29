package bridge.model.bridge;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<BridgeDirection> bridge;

    public Bridge(final List<String> bridge) {
        this.bridge = translateBridgeDirection(bridge);
    }

    private List<BridgeDirection> translateBridgeDirection(final List<String> bridge) {
        return bridge.stream()
                .map(BridgeDirection::fromCommand)
                .collect(Collectors.toList());
    }

    public List<BridgeDirection> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public BridgeDirection getBridgeDirectionByIndex(final int index) {
        return bridge.get(index);
    }
}
