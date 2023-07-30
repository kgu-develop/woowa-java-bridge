package bridge.model.bridge;

import bridge.model.game.GameRoundStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BridgeLine {
    private final List<String> line;

    private BridgeLine() {
        this.line = new ArrayList<>();
    }

    public static BridgeLine create() {
        return new BridgeLine();
    }

    public void addLine(final GameRoundStatus status) {
        line.add(status.getValue());
    }

    public int getLength() {
        return line.size();
    }

    @Override
    public String toString() {
        final StringJoiner joiner = new StringJoiner(" | ", "[ ", " ]");
        for (String value : line) {
            joiner.add(value);
        }
        return joiner.toString();
    }
}
