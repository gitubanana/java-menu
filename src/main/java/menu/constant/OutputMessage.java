package menu.constant;

public enum OutputMessage {
    WELCOME_MESSAGE("점심 메뉴 추천을 시작합니다."),
    COACH_NAME_PROMPT("코치의 이름을 입력해 주세요. (, 로 구분)"),
    ALLERGIC_FOOD_PROMPT("%s(이)가 못 먹는 메뉴를 입력해 주세요."),
    RECOMMEND_START_MESSAGE("메뉴 추천 결과입니다."),
    DAY_OF_RECOMMEND("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    ALIGNED_LINE("[ %s | %s ]"),
    END_MESSAGE("추천을 완료했습니다."),
    DELIMITER(" | "),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String format(Object... objects) {
        return String.format(message, objects);
    }

    @Override
    public String toString() {
        return message;
    }
}
