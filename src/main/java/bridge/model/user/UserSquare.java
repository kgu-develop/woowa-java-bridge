package bridge.model.user;

import bridge.view.InputView;

public class UserSquare {
    private String square;
    
    public UserSquare() {
        String moving = InputView.readMoving();
        validateCharacter(moving);
        
        this.square = moving;
    }
    
    private static void validateCharacter(String moving) {
        if (isInvalidCharacter(moving)) {
            throw new IllegalArgumentException("윗 칸은 [U], 아래 칸은 [D]를 눌러주세요");
        }
    }
    
    private static boolean isInvalidCharacter(String moving) {
        return !moving.equals("U") && !moving.equals("D");
    }
    
    public String getSquare() {
        return square;
    }
}
