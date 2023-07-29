package bridge.utils.validator;

public class BridgeLengthValidator extends Validator {
    private static final int MIN_VALUE = 3;
    private static final int MAX_VALUE = 20;

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
