package bridge.service;

import bridge.model.result.MoveResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeServiceTest {
    @BeforeEach
    void beforeEach() {
        MoveResult.initResultHolder();
    }
    
    @Test
    @DisplayName("모두 정답이면 끝까지 이동할 수 있다.")
    void moveEnd() {
        // given
        List<String> caseA = List.of("U", "U", "U");
        List<String> bridge = List.of("U", "U", "U");
    
        // when
        List<Boolean> moveResult = MoveResult.getMoveResult();
        moveProcess(moveResult, caseA, bridge);
    
        // then
        assertThat(moveResult.size()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("중간에 틀리면 중간까지 이동할 수 있다.")
    void moveMiddle() {
        // given
        List<String> caseA = List.of("U", "U", "U");
        List<String> bridge = List.of("U", "D", "U");
        
        // when
        List<Boolean> moveResult = MoveResult.getMoveResult();
        moveProcess(moveResult, caseA, bridge);
        
        // then
        assertThat(moveResult.size()).isEqualTo(2);
    }
    
    @Test
    @DisplayName("처음부터 틀리면 이동할 수 없다.")
    void notMove() {
        // given
        List<String> caseA = List.of("U", "U", "U");
        List<String> bridge = List.of("D", "U", "U");
        
        // when
        List<Boolean> moveResult = MoveResult.getMoveResult();
        moveProcess(moveResult, caseA, bridge);
        
        // then
        assertThat(moveResult.size()).isEqualTo(1);
    }
    
    // 어플리케이션 시나리오
    private static void moveProcess(List<Boolean> moveResult, List<String> caseA, List<String> bridge) {
        for (int i = 0; i < bridge.size(); i++) {
            boolean eachResult = BridgeService.checkMove(bridge.get(i), caseA.get(i));
            BridgeService.move(moveResult, eachResult);
    
            if (eachResult == false) {
                break;
            }
        }
    }
}