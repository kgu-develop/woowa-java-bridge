package bridge.model.game;

public enum GameStatus {
    IN_PROGRESS,
    TERMINATE,
    GAME_CLEAR,
    GAME_FAIL,
    ;

    public boolean isGameClear() {
        return this == GAME_CLEAR;
    }
}
