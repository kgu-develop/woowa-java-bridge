package bridge.model.result;

import java.util.Arrays;

public enum Compare {
    SAME(true),
    DIFF(false);
    
    private final boolean isSame;
    
    Compare(boolean isSame) {
        this.isSame = isSame;
    }
    
    public static Compare getCompareBy(boolean EachResult) {
        return Arrays.stream(values())
                .filter(Compare -> Compare.isSame == EachResult)
                .findFirst()
                .orElseGet(() -> null);
    }
}
