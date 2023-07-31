package bridge.utils.validator;

import static bridge.utils.BridgeConstants.MAX_VALUE;
import static bridge.utils.BridgeConstants.MIN_VALUE;

public class BridgeLengthValidator extends Validator {
    @Override
    public void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);
        validateBridgeLengthIsInRange(userInput);
    }

    private void validateBridgeLengthIsInRange(final String userInput) {
        if (isOutOfRange(Integer.parseInt(userInput))) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRange(final int bridgeLength) {
        return bridgeLength < MIN_VALUE || bridgeLength > MAX_VALUE;
    }
}
