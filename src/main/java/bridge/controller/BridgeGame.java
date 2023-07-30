package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.bridge.Bridge;
import bridge.model.bridge.BridgeDirection;
import bridge.model.game.GameProcessDecisionCommand;
import bridge.model.game.GameRoundStatus;
import bridge.model.game.GameTracker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.model.game.GameRoundStatus.ROUND_FAIL;
import static bridge.model.game.GameRoundStatus.ROUND_SUCCESS;
import static bridge.model.game.GameStatus.GAME_CLEAR;
import static bridge.model.game.GameStatus.GAME_FAIL;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private GameTracker gameTracker;

    public void run() {
        try {
            initializeGame();
            startGame();
            printGameResult();
        } catch (final IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private void initializeGame() {
        OutputView.printStartGame();
        initializeBridge();
        initalizeGameTracker();
    }

    private void initializeBridge() {
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> bridgeDirections = bridgeMaker.makeBridge(InputView.readBridgeSize());
        bridge = new Bridge(bridgeDirections);
    }

    private void initalizeGameTracker() {
        gameTracker = new GameTracker();
    }

    private void startGame() {
        while (gameTracker.isGameInProgress()) {
            processEachRound();
            handleGameProcess();
        }
    }

    private void processEachRound() {
        final int currentOrder = gameTracker.getCurrentOrder();
        final GameRoundStatus roundStatus = moveEachRound(currentOrder);

        if (roundStatus.isRoundFail()) {
            gameTracker.updateGameStatus(GAME_FAIL);
            return;
        }

        if (roundStatus.isRoundSuccess() && bridge.isEndOfBridge(currentOrder)) {
            gameTracker.updateGameStatus(GAME_CLEAR);
        }
    }

    private GameRoundStatus moveEachRound(final int currentOrder) {
        final BridgeDirection bridgeDirection = bridge.getBridgeDirectionByIndex(currentOrder);
        final BridgeDirection playerMoveCommand = BridgeDirection.fromCommand(InputView.readMoving());
        return move(bridgeDirection, playerMoveCommand);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private GameRoundStatus move(
            final BridgeDirection bridgeDirection,
            final BridgeDirection playerDirection
    ) {
        final GameRoundStatus roundStatus = judgeRoundByDirection(bridgeDirection, playerDirection);
        gameTracker.updateMap(playerDirection, roundStatus);
        return roundStatus;
    }

    private GameRoundStatus judgeRoundByDirection(
            final BridgeDirection bridgeDirection,
            final BridgeDirection playerDirection
    ) {
        if (bridgeDirection == playerDirection) {
            return ROUND_SUCCESS;
        }
        return ROUND_FAIL;
    }

    private void handleGameProcess() {
        if (gameTracker.isGameFail()) {
            handleRetryProcess();
        }
    }

    private void handleRetryProcess() {
        final GameProcessDecisionCommand decisionCommand = GameProcessDecisionCommand.from(InputView.readGameCommand());
        if (decisionCommand.isRetryDecision()) {
            retry();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        gameTracker.retryGame();
    }

    private void printGameResult() {
        OutputView.printResult(gameTracker);
    }
}
