package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RestartStatusTest {
    @Test
    @DisplayName("게임을 재시작한다.")
    void restart() {
        // given
        String signal = "R";
        
        // when
        RestartStatus restartStatus = RestartStatus.getRestartStatusBy(signal);
    
        // then
        assertThat(RestartStatus.RESTART).isEqualTo(restartStatus);
    }
    
    @Test
    @DisplayName("게임을 종료한다.")
    void quit() {
        // given
        String signal = "Q";
        
        // when
        RestartStatus restartStatus = RestartStatus.getRestartStatusBy(signal);
        
        // then
        assertThat(RestartStatus.QUIT).isEqualTo(restartStatus);
    }
}