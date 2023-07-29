package bridge.model.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.model.game.GameProcessDecisionCommand.QUIT;
import static bridge.model.game.GameProcessDecisionCommand.RETRY;
import static bridge.utils.ExceptionConstants.GameProcessDecisionCommandException.INVALID_PROCESS_DECISION_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GameProcessDecisionCommandTest {
    @Test
    @DisplayName("게임 재시작[R], 게임 종료[Q]가 아닌 Command로 GameProcessDecisionCommand를 조회할 수 없다")
    void throwExceptionByInvalidProcessDecisionCommand() {
        assertAll(
                () -> assertThatThrownBy(() -> GameProcessDecisionCommand.from("r"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_PROCESS_DECISION_COMMAND.message),
                () -> assertThatThrownBy(() -> GameProcessDecisionCommand.from("q"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_PROCESS_DECISION_COMMAND.message),
                () -> assertThatThrownBy(() -> GameProcessDecisionCommand.from("h"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_PROCESS_DECISION_COMMAND.message)
        );
    }

    @Test
    @DisplayName("GameProcessDecisionCommand를 조회한다")
    void success() {
        assertAll(
                () -> assertThat(GameProcessDecisionCommand.from("R")).isEqualTo(RETRY),
                () -> assertThat(GameProcessDecisionCommand.from("Q")).isEqualTo(QUIT)
        );
    }
}
