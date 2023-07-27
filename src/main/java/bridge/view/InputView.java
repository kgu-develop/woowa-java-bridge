package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static void printInputLengthMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }
    
    private static void printInputDirectMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        printInputLengthMessage();
        
        String length = Console.readLine();
    
        validateHasWhiteSpace(length);
        validateIsNumeric(length);
        
        return Integer.parseInt(length);
    }
    
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printInputDirectMessage();
    
        String direct = Console.readLine();
        validateHasWhiteSpace(direct);
        
        return direct;
    }
    
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
    
    private static void validateHasWhiteSpace(String input) {
        if (hasWhiteSpace(input)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }
    
    private static boolean hasWhiteSpace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }
    
    private static void validateIsNumeric(String input) {
        try {
            Integer.valueOf(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
    }
}
