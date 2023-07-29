package bridge.model.game;

public enum GameRoundStatus {
    ROUND_SUCCESS("O", true),
    ROUND_FAIL("X", false),
    NONE(" ", false),
    ;

    private final String value;
    private final boolean success;

    GameRoundStatus(
            final String value,
            final boolean success
    ) {
        this.value = value;
        this.success = success;
    }

    public String getValue() {
        return value;
    }

    public boolean isSuccess() {
        return success;
    }
}
