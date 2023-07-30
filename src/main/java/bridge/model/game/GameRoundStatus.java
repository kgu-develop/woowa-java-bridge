package bridge.model.game;

public enum GameRoundStatus {
    ROUND_SUCCESS("O", true),
    ROUND_FAIL("X", false),
    ROUND_NONE(" ", false),
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

    public boolean isRoundSuccess() {
        return this == ROUND_SUCCESS;
    }

    public boolean isRoundFail() {
        return this == ROUND_FAIL;
    }
}
