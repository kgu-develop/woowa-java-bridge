package bridge.utils.validator;

import static bridge.model.game.GameProcessDecisionCommand.QUIT;
import static bridge.model.game.GameProcessDecisionCommand.RETRY;
import static bridge.utils.ExceptionConstants.InputException.INVALID_GAME_PROCESS_COMMAND;

public class GameProcessCommandValidator extends Validator {
    @Override
    public void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateGameProcessCommandIsValid(userInput);
    }

    private void validateGameProcessCommandIsValid(final String userInput) {
        if (isInvalidGameProcessCommand(userInput)) {
            throw new IllegalArgumentException(INVALID_GAME_PROCESS_COMMAND.message);
        }
    }

    private boolean isInvalidGameProcessCommand(final String userInput) {
        return !RETRY.getValue().equals(userInput) && !QUIT.getValue().equals(userInput);
    }
}
