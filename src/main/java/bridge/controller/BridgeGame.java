package bridge.controller;

import bridge.model.RestartStatus;
import bridge.model.bridge.BridgeMaker;
import bridge.model.bridge.BridgeRandomNumberGenerator;
import bridge.model.result.CompareResult;
import bridge.model.result.FinalResult;
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
    
    private static int count;
    
    private static CompareResult compare;
    
    private static RestartStatus restartStatus;
    
    private static FinalResult finalResult;
    
    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeService = new BridgeService();
        count = 0;
    }
    
    public void run() {
        final List<String> bridge = createBridge();
        playGame(bridge);
        endGame();
    }
    
    private List<String> createBridge() {
        return bridgeService.createBridge(bridgeMaker);
    }
    
    private void playGame(final List<String> bridge) {
        do {
            List<Boolean> moveResult = createResultHolder();
            count += 1;
            for (final String bridgeSquare : bridge) {
                move(bridgeSquare, moveResult, bridge);
            
                if (isDifferent()) {
                    break;
                }
            }
            gameOver();
        } while (!isQuit());
    }
    
    private void endGame() {
        bridgeService.end(count, finalResult);
    }
    
    private static List<Boolean> createResultHolder() {
        MoveResult.initResultHolder();
        return MoveResult.getMoveResult();
    }
    
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final String bridgeSquare, List<Boolean> moveResult, final List<String> bridge) {
        final UserSquare userSquare = new UserSquare();
        final boolean eachResult = bridgeService.checkMove(userSquare.getSquare(), bridgeSquare);
        
        compare = CompareResult.getCompareBy(eachResult);
        bridgeService.move(moveResult, eachResult, bridge);
        retry(eachResult);
    }
    
    private static void gameOver() {
        if (isSuccess()) {
            restartStatus = RestartStatus.QUIT;
            finalResult = FinalResult.SUCCESS;
        }
    
        if (isFail()) {
            finalResult = FinalResult.FAIL;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(final boolean eachResult) {
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
    
    private static boolean isSuccess() {
        return compare == CompareResult.SAME;
    }
    
    private static boolean isFail() {
        return compare == CompareResult.DIFF && restartStatus == RestartStatus.QUIT;
    }
}
