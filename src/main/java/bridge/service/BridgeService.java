package bridge.service;

import bridge.model.bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeService {
    public static List<String> createBridge(BridgeMaker bridgeMaker) {
        OutputView.printGameStartMessage();
        int bridgeSize = InputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }
    
    public static void move(List<Boolean> resultHolder, boolean eachResult) {
        resultHolder.add(eachResult);
    
        // eachResult 주면서 outpur view 호출
    }
    
    public static boolean checkMove(String bridgeSquare, String userSquare) {
        return userSquare.equals(bridgeSquare);
    }
}
