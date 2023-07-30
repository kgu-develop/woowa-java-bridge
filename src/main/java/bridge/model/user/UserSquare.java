package bridge.model.user;

import bridge.utils.BridgeConstant;
import bridge.view.InputView;

import static bridge.utils.ExceptionMessage.Input_Exception.INVALID_INPUT_SQUARE_EXCEPTION;

public class UserSquare {
    private String square;
    
    public UserSquare() {
        while (true) {
            try {
                final String moving = InputView.readMoving();
                validateCharacter(moving);
                this.square = moving;
                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static void validateCharacter(final String moving) {
        if (isInvalidCharacter(moving)) {
            throw new IllegalArgumentException(INVALID_INPUT_SQUARE_EXCEPTION.getMessage());
        }
    }
    
    private static boolean isInvalidCharacter(final String moving) {
        return !moving.equals(BridgeConstant.UP_SQUARE) && !moving.equals(BridgeConstant.DOWN_SQUARE);
    }
    
    public String getSquare() {
        return square;
    }
}
