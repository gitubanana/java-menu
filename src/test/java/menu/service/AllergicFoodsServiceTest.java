package menu.service;

import static menu.constant.MenuProperty.ALLERGIC_FOOD_DELIMITER;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("== AllergicFoodsService 테스트 ==")
public class AllergicFoodsServiceTest {
    @ParameterizedTest
    @DisplayName("못 먹는 음식을 잘 구분할 수 있다.")
    @MethodSource("getParseAllergicFoodsArguments")
    void 못_먹는_음식_구분(List<String> allergicFoods) {
        List<String> parsedAllergicFoods = AllergicFoodsService.parseAllergicFoods(
                String.join(ALLERGIC_FOOD_DELIMITER, allergicFoods));

        assertIterableEquals(parsedAllergicFoods, allergicFoods);
    }

    static Stream<List<String>> getParseAllergicFoodsArguments() {
        return Stream.of(
                List.of("브로콜리", "청어", "홍어"),
                List.of("브로콜리"),
                List.of()
        );
    }
}
