package bridge.common;

import bridge.model.game.GameRoundStatus;

import java.util.List;

public class BridgeFixture {
    public static final String INIT_BRIDGE_LINE = String.format("[ %s ]", "");
    public static final String INIT_BRIDGE_MAP =
            new StringBuilder()
                    .append(String.format("[ %s ]", ""))
                    .append("\n")
                    .append(String.format("[ %s ]", ""))
                    .toString();

    public static String createBridgeMap(
            final String upLineFormat,
            final List<GameRoundStatus> upLineDirections,
            final String downLineFormat,
            final List<GameRoundStatus> downLineDirections
    ) {
        return new StringBuilder()
                .append(createBridgeLine(upLineFormat, upLineDirections))
                .append("\n")
                .append(createBridgeLine(downLineFormat, downLineDirections))
                .toString();
    }

    public static String createBridgeLine(
            final String format,
            final List<GameRoundStatus> directions
    ) {
        return String.format(
                format,
                directions.stream()
                        .map(GameRoundStatus::getValue)
                        .toArray()
        );
    }
}
