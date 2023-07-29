package bridge.controller;

import bridge.model.RestartStatus;
import bridge.model.bridge.BridgeMaker;
import bridge.model.bridge.BridgeRandomNumberGenerator;
import bridge.model.result.CompareResult;
import bridge.model.result.MoveResult;
import bridge.model.user.UserSquare;
import bridge.service.BridgeService;
import bridge.view.InputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static BridgeService bridgeService;
    private static BridgeMaker bridgeMaker;
    
    private CompareResult compare;
    
    private RestartStatus restartStatus;
    
    public BridgeGame() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        restartStatus = RestartStatus.RESTART;
        bridgeService = new BridgeService();
    }
    
    public void run() {
        List<String> bridge = createBridge();
        playGame(bridge);
    }
    
    private List<String> createBridge() {
        return bridgeService.createBridge(bridgeMaker);
    }
    
    private void playGame(List<String> bridge) {
        do {
            List<Boolean> moveResult = createResultHolder();
            for (String bridgeSquare : bridge) {
                move(bridgeSquare, moveResult, bridge);
            
                if (isDifferent()) {
                    break;
                }
            }
        
        } while (!isQuit());
    }
    
    private static List<Boolean> createResultHolder() {
        MoveResult.initResultHolder();
        List<Boolean> moveResult = MoveResult.getMoveResult();
        return moveResult;
    }
    
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String bridgeSquare, List<Boolean> moveResult, List<String> bridge) {
        UserSquare userSquare = new UserSquare();
        boolean eachResult = bridgeService.checkMove(userSquare.getSquare(), bridgeSquare);
        
        compare = CompareResult.getCompareBy(eachResult);
        bridgeService.move(moveResult, eachResult, bridge);
        retry(eachResult);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(boolean eachResult) {
        if (eachResult == false) {
            restartStatus = bridgeService.retry();
        }
    }
    
    private boolean isDifferent() {
        return compare == CompareResult.DIFF;
    }
    
    private boolean isQuit() {
        return restartStatus == RestartStatus.QUIT;
    }
}
