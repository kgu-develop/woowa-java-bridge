package bridge.model.bridge;

import bridge.model.game.GameRoundStatus;

import static bridge.model.bridge.BridgeDirection.DOWN;
import static bridge.model.bridge.BridgeDirection.UP;
import static bridge.model.game.GameRoundStatus.ROUND_NONE;

public class BridgeMap {
    private final BridgeLine upLine;
    private final BridgeLine downLine;

    private BridgeMap(
            final BridgeLine upLine,
            final BridgeLine downLine
    ) {
        this.upLine = upLine;
        this.downLine = downLine;
    }

    public static BridgeMap init() {
        return new BridgeMap(BridgeLine.create(), BridgeLine.create());
    }

    public void updateMap(
            final BridgeDirection direction,
            final GameRoundStatus status
    ) {
        if (direction == UP) {
            upLine.addLine(status);
            downLine.addLine(ROUND_NONE);
        }

        if (direction == DOWN) {
            upLine.addLine(ROUND_NONE);
            downLine.addLine(status);
        }
    }

    @Override
    public String toString() {
        return upLine.toString() + "\n" + downLine.toString();
    }
}
