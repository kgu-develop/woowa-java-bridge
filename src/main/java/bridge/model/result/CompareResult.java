package bridge.model.result;

import java.util.Arrays;

public enum CompareResult {
    SAME(true),
    DIFF(false);
    
    private final boolean isSame;
    
    CompareResult(boolean isSame) {
        this.isSame = isSame;
    }
    
    public static CompareResult getCompareBy(boolean EachResult) {
        return Arrays.stream(values())
                .filter(Compare -> Compare.isSame == EachResult)
                .findFirst()
                .orElseGet(() -> null);
    }
}
