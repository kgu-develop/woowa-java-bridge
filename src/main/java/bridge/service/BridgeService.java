package bridge.service;

import bridge.model.bridge.BridgeMaker;
import bridge.view.InputView;

import java.util.List;

public class BridgeService {
    public List<String> createBridge(BridgeMaker bridgeMaker) {
        int bridgeSize = InputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
