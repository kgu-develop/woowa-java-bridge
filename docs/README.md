## Feature

> 입력 예외가 발생한 경우 `[Error] {message}` 형태로 출력 후 다시 입력 진행

- 다리의 길이를 `입력`받고 입력받은 Length(N)만큼 다리를 설치한다
  - 다리의 길이가 `3..20`이 아닌 경우 예외 처리
  - 각 길이 별 숫자가 0이면 위 칸(U), 1이면 아래 칸(D)을 건널 수 있다

- 플레이어는 이동할 칸을 입력한다
  - U or D가 아닌 경우 예외 처리
  - 이동을 하고 난 후 해당 칸을 건널 수 있으면 O, 없으면 X를 다리에 표시한다

- 플레이어는 다리를 완전히 건너면 게임을 클리어한다

- 플레이어는 다리 건너기에 실패하면 `재시작(R) / 종료(Q)`중에 하나를 선택할 수 있다
  - 재시작(R) -> 처음 생성한 다리 그대로 다시 건너기
  - 종료(Q) -> 게임 종료

- 플레이어는 게임을 클리어 했거나 건너기 실패 후 종료하면 게임 결과를 받을 수 있다
  1. 사용자가 진행한 게임 결과
  2. 게임 성공 여부 (성공 / 실패)
  3. 총 시도 횟수 (다리 건넌 횟수)

<br>
<hr>

## Model

### `bridge/BridgeDirection`

- 다리 이동 방향과 관련된 Enum 컴포넌트

### `bridge/Bridge`

- Input Size 길이만큼 랜덤 생성된 Bridge 컴포넌트
  - 사용자가 건너갈 Bridge의 정답 기준

### `bridge/BridgeMap`

- 사용자가 건너는 전체 다리 정보와 관련된 Map 컴포넌트

### `game/GameStatus`

- 게임 상태와 관련된 Enum 컴포넌트
  - `START` -> 게임 시작
  - `RETRY` -> 게임 재시작
  - `QUIT` -> 게임 종료

### `game/GameResultStatus`

- 게임 종료 상태와 관련된 Enum 컴포넌트
  - `SUCCESS` -> 게임 성공
  - `FAILURE` -> 게임 실패

### `game/GameTracker`

- 게임 진행과 관련된 컴포넌트를 묶은 컴포넌트
  - 시도 횟수
  - 다리 전체 맵
  - 게임 현재 상태

<br>
<hr>

## Utils

### `ExceptionConstants`

- 전역 예외 메시지 통합 컴포넌트

### `validator/Validator`

- 사용자 Input에 대한 기본 검증 컴포넌트

<br>
<hr>

## View

### `InputView`

- 사용자 Input을 받기 위한 컴포넌트

### `OutputView`

- 다리 건너기 게임 진행과 관련된 출력 컴포넌트

<br>
<hr>

## Controller

### `GameController`

- 다리 건너기 게임 진행과 관련된 컨트롤러

<br>
