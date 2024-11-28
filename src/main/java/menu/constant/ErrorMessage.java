package menu.constant;

import static menu.constant.MenuProperty.MAX_ALLERGIC_COUNT;
import static menu.constant.MenuProperty.MAX_COACH_COUNT;
import static menu.constant.MenuProperty.MAX_NAME_LENGTH;
import static menu.constant.MenuProperty.MIN_COACH_COUNT;
import static menu.constant.MenuProperty.MIN_NAME_LENGTH;

public enum ErrorMessage {
    TOO_SHORT_NAME("이름은 최소 " + MIN_NAME_LENGTH + "글자여야 합니다."),
    TOO_LONG_NAME("이름은 최대 " + MAX_NAME_LENGTH + "글자여야 합니다."),
    TOO_SMALL_COACH_COUNT("코치는 최소 " + MIN_COACH_COUNT + "명 이상 입력해야 합니다."),
    TOO_LARGE_COACH_COUNT("코치는 최대 " + MAX_COACH_COUNT + "명 이하 입력해야 합니다."),
    TOO_MANY_ALLERGIC_COUNT("못 먹는 음식은 최대 " + MAX_ALLERGIC_COUNT + "개여야 합니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
