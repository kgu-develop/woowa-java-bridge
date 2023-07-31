package bridge.utils.validator;

import static bridge.utils.ExceptionConstants.InputException.INPUT_MUST_BE_NUMERIC;
import static bridge.utils.ExceptionConstants.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;

public abstract class Validator {
    abstract void validate(final String userInput);

    protected void validateInputHasSpace(final String userInput) {
        if (hasSpace(userInput)) {
            throw new IllegalArgumentException(INPUT_MUST_NOT_CONTAINS_SPACE.message);
        }
    }

    private boolean hasSpace(final String userInput) {
        return userInput.chars()
                .anyMatch(Character::isWhitespace);
    }

    protected void validateInputIsNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NUMERIC.message);
        }
    }
}
