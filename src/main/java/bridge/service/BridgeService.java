package bridge.service;

import bridge.model.RestartStatus;
import bridge.model.bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeService {
    public List<String> createBridge(BridgeMaker bridgeMaker) {
        OutputView.printGameStartMessage();
        int bridgeSize = InputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }
    
    public void move(List<Boolean> resultHolder, boolean eachResult, List<String> bridge) {
        resultHolder.add(eachResult);
        OutputView.printMap(bridge, resultHolder);
    }
    
    public boolean checkMove(String bridgeSquare, String userSquare) {
        return userSquare.equals(bridgeSquare);
    }
    
    public RestartStatus retry() {
        String signal = InputView.readGameCommand();
        return RestartStatus.getRestartStatusBy(signal);
    }
}
