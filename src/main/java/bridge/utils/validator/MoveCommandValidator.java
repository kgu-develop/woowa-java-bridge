package bridge.utils.validator;

import static bridge.model.bridge.BridgeDirection.DOWN;
import static bridge.model.bridge.BridgeDirection.UP;
import static bridge.utils.ExceptionConstants.InputException.INVALID_MOVE_COMMAND;

public class MoveCommandValidator extends Validator {
    @Override
    public void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateMoveCommandIsValid(userInput);
    }

    private void validateMoveCommandIsValid(final String userInput) {
        if (isInvalidMoveCommand(userInput)) {
            throw new IllegalArgumentException(INVALID_MOVE_COMMAND.message);
        }
    }

    private boolean isInvalidMoveCommand(final String userInput) {
        return !UP.getCommand().equals(userInput) && !DOWN.getCommand().equals(userInput);
    }
}
