package bridge.model.game;

public enum GameResultStatus {
    CLEAR("성공"),
    FAIL("실패"),
    ;

    private final String value;

    GameResultStatus(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
