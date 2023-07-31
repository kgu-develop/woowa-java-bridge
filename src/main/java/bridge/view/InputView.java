package bridge.view;

import bridge.utils.validator.BridgeLengthValidator;
import bridge.utils.validator.GameProcessCommandValidator;
import bridge.utils.validator.MoveCommandValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_COMMAND = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_PROCESS_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final BridgeLengthValidator BRIDGE_LENGTH_VALIDATOR = new BridgeLengthValidator();
    private static final MoveCommandValidator MOVE_COMMAND_VALIDATOR = new MoveCommandValidator();
    private static final GameProcessCommandValidator GAME_PROCESS_COMMAND_VALIDATOR = new GameProcessCommandValidator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            System.out.println(INPUT_BRIDGE_LENGTH);

            final String input = Console.readLine();
            BRIDGE_LENGTH_VALIDATOR.validate(input);

            return Integer.parseInt(input);
        } catch (final IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        try {
            System.out.println(INPUT_MOVE_COMMAND);

            final String input = Console.readLine();
            MOVE_COMMAND_VALIDATOR.validate(input);

            return input;
        } catch (final IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        try {
            System.out.println(INPUT_GAME_PROCESS_COMMAND);

            final String input = Console.readLine();
            GAME_PROCESS_COMMAND_VALIDATOR.validate(input);

            return input;
        } catch (final IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readGameCommand();
        }
    }
}
