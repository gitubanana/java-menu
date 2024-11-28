package menu.service;

import static menu.constant.MenuProperty.ALLERGIC_FOOD_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllergicFoodsService {
    private static final int INCLUDE_TRAILING = -1;

    private AllergicFoodsService() {
    }

    public static List<String> parseAllergicFoods(String line) {
        if (line.isBlank()) {
            return List.of();
        }

        return Arrays.stream(line.split(ALLERGIC_FOOD_DELIMITER, INCLUDE_TRAILING))
                .collect(Collectors.toList());
    }
}
