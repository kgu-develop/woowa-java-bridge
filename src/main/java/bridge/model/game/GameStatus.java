package bridge.model.game;

public enum GameStatus {
    IN_PROGRESS,
    GAME_CLEAR,
    GAME_FAIL,
    ;

    public boolean isGameInProgress() {
        return this == IN_PROGRESS;
    }

    public boolean isGameClear() {
        return this == GAME_CLEAR;
    }

    public boolean isGameFail() {
        return this == GAME_FAIL;
    }
}
