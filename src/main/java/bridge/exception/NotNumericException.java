package bridge.exception;

public class NotNumericException extends IllegalArgumentException{
    public NotNumericException(final String message) {
        super(message);
    }
}
