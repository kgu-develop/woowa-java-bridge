package bridge.service;

import bridge.model.RestartStatus;
import bridge.model.bridge.BridgeMaker;
import bridge.model.result.FinalResult;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeService {
    public List<String> createBridge(BridgeMaker bridgeMaker) {
        while (true) {
            try {
                OutputView.printGameStartMessage();
                
                return bridgeMaker.makeBridge(InputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public boolean checkMove(String bridgeSquare, String userSquare) {
        return userSquare.equals(bridgeSquare);
    }
    
    public void move(List<Boolean> moveResult, boolean eachResult, List<String> bridge) {
        moveResult.add(eachResult);
        OutputView.printMap(bridge, moveResult);
    }
    
    public RestartStatus retry() {
        while (true) {
            try {
                return RestartStatus.getRestartStatusBy(InputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void end(int count, FinalResult finalResult) {
        OutputView.printResult(count, finalResult);
    }
}
