package bridge.model.game;

import java.util.Arrays;

import static bridge.utils.ExceptionConstants.GameProcessDecisionCommandException.INVALID_PROCESS_DECISION_COMMAND;

public enum GameProcessDecisionCommand {
    RETRY("R"),
    QUIT("Q"),
    ;

    private final String value;

    GameProcessDecisionCommand(final String value) {
        this.value = value;
    }

    public static GameProcessDecisionCommand from(final String value) {
        return Arrays.stream(values())
                .filter(gameProcessDecisionCommand -> gameProcessDecisionCommand.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PROCESS_DECISION_COMMAND.message));
    }
}
