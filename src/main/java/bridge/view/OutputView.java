package bridge.view;

import bridge.model.result.FinalResult;

import java.util.List;

import static bridge.utils.BridgeConstant.DOWN_SQUARE;
import static bridge.utils.BridgeConstant.UP_SQUARE;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_OVER_MESSAGE = "최종 게임 결과";
    private static final String OPEN_BRACKETS = "[";
    private static final String CLOSE_BRACKETS = "]";
    private static final String SEPARATOR = "|";
    private static final String COLLECT_SIGN = " O ";
    private static final String GAP = "   ";
    private static final String NEW_LINE = "\n";
    private static final String WRONG_SIGN = " X ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String GAME_SUCCESS_WHETHER = "게임 성공 여부: ";
    private static final String TYR_COUNT = "총 시도한 횟수: ";
    private static final int START_NUMBER = 0;
    private static String finalSquares;
    
    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE + NEW_LINE);
    }
    

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(final List<String> bridge, final List<Boolean> moveResult) {
        StringBuilder upSquares = new StringBuilder(OPEN_BRACKETS);
        StringBuilder downSquares = new StringBuilder(OPEN_BRACKETS);
        
        for (int i = 0; i < moveResult.size(); i++) {
            if (i > START_NUMBER) {
                upSquares.append(SEPARATOR);
                downSquares.append(SEPARATOR);
            }
            
            if (isUpDirectSame(bridge, moveResult, i)) {
                upSquares.append(COLLECT_SIGN);
                downSquares.append(GAP);
            }
            if (isUpDirectNotSame(bridge, moveResult, i)) {
                upSquares.append(GAP);
                downSquares.append(WRONG_SIGN);
            }
            if (isDownDirectSame(bridge, moveResult, i)) {
                upSquares.append(GAP);
                downSquares.append(COLLECT_SIGN);
            }
            if (isDownDirectNotSame(bridge, moveResult, i)) {
                upSquares.append(WRONG_SIGN);
                downSquares.append(GAP);
            }
        }
    
        upSquares.append(CLOSE_BRACKETS + NEW_LINE);
        downSquares.append(CLOSE_BRACKETS + NEW_LINE);
        
        finalSquares = upSquares.append(downSquares).toString();
        System.out.println(finalSquares);
    }
    
    private static boolean isDownDirectNotSame(final List<String> bridge, final List<Boolean> moveResult, final int i) {
        return bridge.get(i).equals(DOWN_SQUARE) && moveResult.get(i) == false;
    }
    
    private static boolean isUpDirectNotSame(final List<String> bridge, final List<Boolean> moveResult, final int i) {
        return bridge.get(i).equals(UP_SQUARE) && moveResult.get(i) == false;
    }
    
    private static boolean isDownDirectSame(final List<String> bridge, final List<Boolean> moveResult, final int i) {
        return bridge.get(i).equals(DOWN_SQUARE) && moveResult.get(i) == true;
    }
    
    private static boolean isUpDirectSame(final List<String> bridge, final List<Boolean> moveResult, final int i) {
        return bridge.get(i).equals(UP_SQUARE) && moveResult.get(i) == true;
    }
    
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(final int count, final FinalResult finalResult) {
        StringBuilder finalMessage = new StringBuilder();
        String result = SUCCESS;
        
        if (finalResult == FinalResult.FAIL) {
            result = FAIL;
        }
    
        finalMessage.append(GAME_OVER_MESSAGE + NEW_LINE)
                .append(finalSquares + NEW_LINE)
                .append(GAME_SUCCESS_WHETHER + result + NEW_LINE)
                .append(TYR_COUNT + count + NEW_LINE);
    
        System.out.println(finalMessage);
    }
}
