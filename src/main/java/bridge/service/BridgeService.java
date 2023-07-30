package bridge.service;

import bridge.model.RestartStatus;
import bridge.model.bridge.BridgeMaker;
import bridge.model.result.FinalResult;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeService {
    public List<String> createBridge(final BridgeMaker bridgeMaker) {
        while (true) {
            try {
                OutputView.printGameStartMessage();
                
                return bridgeMaker.makeBridge(InputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public boolean checkMove(final String bridgeSquare, final String userSquare) {
        return userSquare.equals(bridgeSquare);
    }
    
    public void move(List<Boolean> moveResult, final boolean eachResult, final List<String> bridge) {
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
    
    public void end(final int count, final FinalResult finalResult) {
        OutputView.printResult(count, finalResult);
    }
}
