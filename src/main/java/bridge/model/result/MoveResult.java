package bridge.model.result;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    
    private static List<Boolean> moveResult;
    private MoveResult() {
    }
    
    public static void initResultHolder() {
        moveResult = null;
    }
    
    public static List<Boolean> getMoveResult() {
        if (moveResult == null) {
            moveResult = new ArrayList<>();
        }
        return moveResult;
    }
}
