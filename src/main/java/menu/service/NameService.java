package menu.service;

import static menu.constant.ErrorMessage.TOO_LARGE_COACH_COUNT;
import static menu.constant.ErrorMessage.TOO_SMALL_COACH_COUNT;
import static menu.constant.MenuProperty.MAX_COACH_COUNT;
import static menu.constant.MenuProperty.MIN_COACH_COUNT;
import static menu.constant.MenuProperty.NAME_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Name;

public class NameService {
    private static final int INCLUDE_TRAILING = -1;

    private NameService() {
    }

    public static List<Name> parseNames(String line) {
        List<Name> names = Arrays.stream(line.split(NAME_DELIMITER, INCLUDE_TRAILING))
                .map(Name::new)
                .collect(Collectors.toList());

        validate(names);
        return names;
    }

    private static void validate(List<Name> names) {
        validateNameCountMin(names);
        validateNameCountMax(names);
    }

    private static void validateNameCountMin(List<Name> names) {
        if (names.size() < MIN_COACH_COUNT) {
            throw new IllegalArgumentException(TOO_SMALL_COACH_COUNT.getMessage());
        }
    }

    private static void validateNameCountMax(List<Name> names) {
        if (names.size() > MAX_COACH_COUNT) {
            throw new IllegalArgumentException(TOO_LARGE_COACH_COUNT.getMessage());
        }
    }
}
