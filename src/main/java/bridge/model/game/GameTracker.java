package bridge.model.game;

import bridge.model.bridge.BridgeDirection;
import bridge.model.bridge.BridgeMap;

import static bridge.model.game.GameResultStatus.CLEAR;
import static bridge.model.game.GameResultStatus.FAIL;
import static bridge.model.game.GameStatus.IN_PROGRESS;

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
        gameStatus = IN_PROGRESS;
        attemptCount++;
    }

    public void updateGameStatus(final GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String displayResultStatus() {
        if (isGameClear()) {
            return CLEAR.getValue();
        }
        return FAIL.getValue();
    }

    public int getCurrentOrder() {
        return bridgeMap.getLineLength();
    }

    public boolean isGameInProgress() {
        return gameStatus.isGameInProgress();
    }

    public boolean isGameClear() {
        return gameStatus.isGameClear();
    }

    public boolean isGameFail() {
        return gameStatus.isGameFail();
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
