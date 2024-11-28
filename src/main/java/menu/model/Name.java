package menu.model;

import static menu.constant.ErrorMessage.TOO_LONG_NAME;
import static menu.constant.ErrorMessage.TOO_SHORT_NAME;
import static menu.constant.MenuProperty.MAX_NAME_LENGTH;
import static menu.constant.MenuProperty.MIN_NAME_LENGTH;

public class Name {
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateShortInLength(name);
        validateLongInLength(name);
    }

    private void validateShortInLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(TOO_SHORT_NAME.getMessage());
        }
    }

    private void validateLongInLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(TOO_LONG_NAME.getMessage());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
