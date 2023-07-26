package bridge.model.bridge;

import java.util.Arrays;

public enum Direct {
    U(1),
    D(0);
    
    public final int directNumber;
    
    Direct(int directNumber) {
        this.directNumber = directNumber;
    }
    
    public static Direct getDirectBy(int directNumber) {
        return Arrays.stream(values())
                .filter(Direct -> Direct.directNumber == directNumber)
                .findFirst()
                .orElseGet(() -> null);
    }
}
