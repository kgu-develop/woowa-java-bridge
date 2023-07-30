package bridge.model.bridge;

import java.util.Arrays;

import static bridge.utils.ExceptionConstants.BridgeDirectionException.INVALID_DIRECTION_COMMAND;
import static bridge.utils.ExceptionConstants.BridgeDirectionException.INVALID_DIRECTION_NUMBER;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D"),
    ;

    private final int number;
    private final String command;

    BridgeDirection(
            final int number,
            final String command
    ) {
        this.number = number;
        this.command = command;
    }

    public static BridgeDirection fromNumber(final int number) {
        return Arrays.stream(values())
                .filter(bridgeDirection -> bridgeDirection.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_DIRECTION_NUMBER.message));
    }

    public static BridgeDirection fromCommand(final String command) {
        return Arrays.stream(values())
                .filter(bridgeDirection -> bridgeDirection.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_DIRECTION_COMMAND.message));
    }

    public int getNumber() {
        return number;
    }

    public String getCommand() {
        return command;
    }
}
