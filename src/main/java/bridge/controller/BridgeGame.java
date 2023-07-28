package bridge.controller;

import bridge.model.bridge.BridgeMaker;
import bridge.model.bridge.BridgeRandomNumberGenerator;
import bridge.model.result.Compare;
import bridge.model.result.MoveResult;
import bridge.model.user.UserSquare;
import bridge.service.BridgeService;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static BridgeService bridgeService;
    private static BridgeMaker bridgeMaker;
    
    private Compare compare;
    
    public BridgeGame() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }
    
    public void run() {
        List<String> bridge = createBridge();
        playGame(bridge);
    }
    
    private List<String> createBridge() {
        return BridgeService.createBridge(bridgeMaker);
    }
    
    private void playGame(List<String> bridge) {
        MoveResult.initResultHolder();
        List<Boolean> moveResult = MoveResult.getMoveResult();
        // while
        for (String bridgeSquare : bridge) {
            move(bridgeSquare, moveResult);
            
            if(compare == Compare.DIFF) break;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String bridgeSquare, List<Boolean> moveResult) {
        UserSquare userSquare = new UserSquare();
        boolean eachResult = BridgeService.checkMove(userSquare.getSquare(), bridgeSquare);
        
        compare = Compare.getCompareBy(eachResult);
        BridgeService.move(moveResult, eachResult);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
