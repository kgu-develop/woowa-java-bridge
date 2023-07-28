package bridge.model.user;

import bridge.view.InputView;

public class UserSquare {
    private String square;
    
    public UserSquare() {
        this.square = InputView.readMoving();
    }
    
    public String getSquare() {
        return square;
    }
}
