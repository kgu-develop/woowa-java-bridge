package bridge.model.game;

import bridge.model.bridge.BridgeDirection;
import bridge.model.bridge.BridgeMap;

import static bridge.model.game.GameResultStatus.CLEAR;
import static bridge.model.game.GameResultStatus.FAIL;
import static bridge.model.game.GameStatus.IN_PROGRESS;
import static bridge.model.game.GameStatus.TERMINATE;

public class GameTracker {
    private BridgeMap bridgeMap;
    private GameStatus gameStatus;
    private int attemptCount;

    public GameTracker() {
        this.bridgeMap = BridgeMap.init();
        this.gameStatus = IN_PROGRESS;
        this.attemptCount = 1;
    }

    public void updateMap(
            final BridgeDirection direction,
            final GameRoundStatus status
    ) {
        bridgeMap.updateMap(direction, status);
    }

    public void retryGame() {
        bridgeMap = BridgeMap.init();
        attemptCount++;
    }

    public void terminateGame() {
        gameStatus = TERMINATE;
    }

    public void updateGameStatus(final GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String displayResultStatus() {
        return gameStatus.isGameClear() ? CLEAR.getValue() : FAIL.getValue();
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
