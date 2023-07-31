package bridge.view;

import bridge.model.bridge.BridgeMap;
import bridge.model.game.GameTracker;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String GAME_IS_SUCCESSFUL = "게임 성공 여부: %s";
    private static final String NUMBER_OF_ATTEMPTS = "총 시도한 횟수: %d";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    public static void printStartGame() {
        System.out.println(START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(final BridgeMap bridgeMap) {
        System.out.println(bridgeMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(final GameTracker gameTracker) {
        System.out.println(FINAL_RESULT);
        System.out.println(gameTracker.getBridgeMap());
        System.out.println(String.format(GAME_IS_SUCCESSFUL, gameTracker.displayResultStatus()));
        System.out.println(String.format(NUMBER_OF_ATTEMPTS, gameTracker.getAttemptCount()));
    }

    public static void printErrorMessage(final String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
