package bridge.model.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.common.BridgeFixture.INIT_BRIDGE_MAP;
import static bridge.common.BridgeFixture.createBridgeMap;
import static bridge.model.bridge.BridgeDirection.DOWN;
import static bridge.model.bridge.BridgeDirection.UP;
import static bridge.model.game.GameRoundStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BridgeGameTest {
    @Test
    @DisplayName("사용자가 다리를 건넌다")
    void move() {
        final BridgeGame bridgeGame = new BridgeGame(new GameTracker());

        /* 정답 = U / 사용자 = U */
        bridgeGame.move(UP, UP);
        assertThat(bridgeGame.getGameTracker().getBridgeMap().toString())
                .isEqualTo(
                        createBridgeMap(
                                "[ %s ]", List.of(ROUND_SUCCESS),
                                "[ %s ]", List.of(ROUND_NONE)
                        )
                );

        /* 정답 = D / 사용자 = D */
        bridgeGame.move(DOWN, DOWN);
        assertThat(bridgeGame.getGameTracker().getBridgeMap().toString())
                .isEqualTo(
                        createBridgeMap(
                                "[ %s | %s ]", List.of(ROUND_SUCCESS, ROUND_NONE),
                                "[ %s | %s ]", List.of(ROUND_NONE, ROUND_SUCCESS)
                        )
                );

        /* 정답 = D / 사용자 = U */
        bridgeGame.move(DOWN, UP);
        assertThat(bridgeGame.getGameTracker().getBridgeMap().toString())
                .isEqualTo(
                        createBridgeMap(
                                "[ %s | %s | %s ]", List.of(ROUND_SUCCESS, ROUND_NONE, ROUND_FAIL),
                                "[ %s | %s | %s ]", List.of(ROUND_NONE, ROUND_SUCCESS, ROUND_NONE)
                        )
                );
    }

    @Test
    @DisplayName("게임을 재시작한다")
    void retry() {
        final BridgeGame bridgeGame = new BridgeGame(new GameTracker());
        assertAll(
                () -> assertThat(bridgeGame.getGameTracker().getBridgeMap().toString()).isEqualTo(INIT_BRIDGE_MAP),
                () -> assertThat(bridgeGame.getGameTracker().getAttemptCount()).isEqualTo(1)
        );

        /* 정답 = U / 사용자 = U */
        bridgeGame.move(UP, UP);
        assertThat(bridgeGame.getGameTracker().getBridgeMap().toString())
                .isEqualTo(
                        createBridgeMap(
                                "[ %s ]", List.of(ROUND_SUCCESS),
                                "[ %s ]", List.of(ROUND_NONE)
                        )
                );

        /* 게임 재시작 */
        bridgeGame.retry();
        assertAll(
                () -> assertThat(bridgeGame.getGameTracker().getBridgeMap().toString()).isEqualTo(INIT_BRIDGE_MAP),
                () -> assertThat(bridgeGame.getGameTracker().getAttemptCount()).isEqualTo(2)
        );
    }
}
