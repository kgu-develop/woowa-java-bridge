package bridge.model.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.model.bridge.BridgeDirection.DOWN;
import static bridge.model.bridge.BridgeDirection.UP;
import static bridge.model.game.GameResultStatus.CLEAR;
import static bridge.model.game.GameResultStatus.FAIL;
import static bridge.model.game.GameRoundStatus.*;
import static bridge.model.game.GameStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GameTrackerTest {
    private static final String INIT_MAP =
            new StringBuilder()
                    .append(String.format("[ %s ]", ""))
                    .append("\n")
                    .append(String.format("[ %s ]", ""))
                    .toString();

    @Test
    @DisplayName("GameTracker를 생성한다")
    void construct() {
        // when
        final GameTracker gameTracker = new GameTracker();

        // then
        assertAll(
                () -> assertThat(gameTracker.getBridgeMap().toString()).isEqualTo(INIT_MAP),
                () -> assertThat(gameTracker.getGameStatus()).isEqualTo(IN_PROGRESS),
                () -> assertThat(gameTracker.getAttemptCount()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("다리 건너기를 진행한다 (updateMap)")
    void updateMap() {
        final GameTracker gameTracker = new GameTracker();
        assertThat(gameTracker.getBridgeMap().toString()).isEqualTo(INIT_MAP);

        gameTracker.updateMap(UP, ROUND_SUCCESS);
        StringBuilder result = new StringBuilder()
                .append(String.format("[ %s ]", ROUND_SUCCESS.getValue()))
                .append("\n")
                .append(String.format("[ %s ]", ROUND_NONE.getValue()));
        assertThat(gameTracker.getBridgeMap().toString()).isEqualTo(result.toString());

        gameTracker.updateMap(DOWN, ROUND_FAIL);
        result = new StringBuilder()
                .append(String.format("[ %s | %s ]", ROUND_SUCCESS.getValue(), ROUND_NONE.getValue()))
                .append("\n")
                .append(String.format("[ %s | %s ]", ROUND_NONE.getValue(), ROUND_FAIL.getValue()));
        assertThat(gameTracker.getBridgeMap().toString()).isEqualTo(result.toString());
    }

    @Test
    @DisplayName("게임을 재시작한다")
    void retryGame() {
        final GameTracker gameTracker = new GameTracker();
        assertAll(
                () -> assertThat(gameTracker.getBridgeMap().toString()).isEqualTo(INIT_MAP),
                () -> assertThat(gameTracker.getGameStatus()).isEqualTo(IN_PROGRESS),
                () -> assertThat(gameTracker.getAttemptCount()).isEqualTo(1)
        );

        /* 다리 건너기 2회 진행 */
        gameTracker.updateMap(UP, ROUND_SUCCESS);
        StringBuilder result = new StringBuilder()
                .append(String.format("[ %s ]", ROUND_SUCCESS.getValue()))
                .append("\n")
                .append(String.format("[ %s ]", ROUND_NONE.getValue()));
        assertThat(gameTracker.getBridgeMap().toString()).isEqualTo(result.toString());

        gameTracker.updateMap(DOWN, ROUND_FAIL);
        result = new StringBuilder()
                .append(String.format("[ %s | %s ]", ROUND_SUCCESS.getValue(), ROUND_NONE.getValue()))
                .append("\n")
                .append(String.format("[ %s | %s ]", ROUND_NONE.getValue(), ROUND_FAIL.getValue()));
        assertThat(gameTracker.getBridgeMap().toString()).isEqualTo(result.toString());

        /* 게임 재시작 */
        gameTracker.retryGame();
        assertAll(
                () -> assertThat(gameTracker.getBridgeMap().toString()).isEqualTo(INIT_MAP),
                () -> assertThat(gameTracker.getGameStatus()).isEqualTo(IN_PROGRESS),
                () -> assertThat(gameTracker.getAttemptCount()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("게임을 종료시킨다")
    void terminateGame() {
        final GameTracker gameTracker = new GameTracker();
        assertAll(
                () -> assertThat(gameTracker.getBridgeMap().toString()).isEqualTo(INIT_MAP),
                () -> assertThat(gameTracker.getGameStatus()).isEqualTo(IN_PROGRESS),
                () -> assertThat(gameTracker.getAttemptCount()).isEqualTo(1)
        );

        gameTracker.terminateGame();
        assertAll(
                () -> assertThat(gameTracker.getGameStatus()).isEqualTo(TERMINATE),
                () -> assertThat(gameTracker.getAttemptCount()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("게임 성공/실패 결과를 응답받는다")
    void displayResultStatus() {
        final GameTracker gameTracker = new GameTracker();

        /* 게임 클리어 */
        gameTracker.updateGameStatus(GAME_CLEAR);
        assertThat(gameTracker.displayResultStatus()).isEqualTo(CLEAR.getValue());

        /* 게임 실패 */
        gameTracker.updateGameStatus(GAME_FAIL);
        assertThat(gameTracker.displayResultStatus()).isEqualTo(FAIL.getValue());
    }
}
