package bridge.model.game;

import bridge.model.bridge.BridgeDirection;

import static bridge.model.game.GameRoundStatus.ROUND_FAIL;
import static bridge.model.game.GameRoundStatus.ROUND_SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final GameTracker gameTracker;

    public BridgeGame(final GameTracker gameTracker) {
        this.gameTracker = gameTracker;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(
            final BridgeDirection bridgeDirection,
            final BridgeDirection playerDirection
    ) {
        final GameRoundStatus roundStatus = judgeRoundByDirection(bridgeDirection, playerDirection);
        gameTracker.updateMap(playerDirection, roundStatus);
    }

    private GameRoundStatus judgeRoundByDirection(
            final BridgeDirection bridgeDirection,
            final BridgeDirection playerDirection
    ) {
        return bridgeDirection == playerDirection ? ROUND_SUCCESS : ROUND_FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameTracker.retryGame();
    }

    public GameTracker getGameTracker() {
        return gameTracker;
    }
}
