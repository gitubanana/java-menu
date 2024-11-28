package menu.model;

import static menu.constant.ErrorMessage.TOO_MANY_ALLERGIC_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("== AllergicFoods 테스트 ==")
public class AllergicFoodsTest {
    @ParameterizedTest
    @DisplayName("3개 이상 못 먹을 경우 예외를 발생시킬 수 있다.")
    @MethodSource("getTooManyAllergicCountArguments")
    void 세_개이상_예외(List<String> allergicFoods) {
        assertThatThrownBy(() -> new AllergicFoods(allergicFoods))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_MANY_ALLERGIC_COUNT.getMessage());
    }

    static Stream<List<String>> getTooManyAllergicCountArguments() {
        return Stream.of(
                List.of("간장게장", "새우튀김", "땅콩"),
                List.of("초밥", "회", "꿀", "리조또")
        );
    }

    @ParameterizedTest
    @DisplayName("못 먹는 음식인지 아닌지 판별할 수 있다.")
    @MethodSource("getContainsArguments")
    void 못_먹는_음식_판별(List<String> allergicFoods, String food, final boolean expected) {
        assertThat(new AllergicFoods(allergicFoods).contains(food))
                .isEqualTo(expected);
    }

    static Stream<Arguments> getContainsArguments() {
        return Stream.of(
                Arguments.of(List.of("간장게장", "새우튀김"), "간장게장", true),
                Arguments.of(List.of("간장게장", "새우튀김"), "양념게장", false),
                Arguments.of(List.of("회"), "회", true),
                Arguments.of(List.of("회"), "꽃게탕", false)
        );
    }
}
