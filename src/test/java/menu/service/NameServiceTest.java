package menu.service;

import static menu.constant.ErrorMessage.TOO_LARGE_COACH_COUNT;
import static menu.constant.ErrorMessage.TOO_SMALL_COACH_COUNT;
import static menu.constant.MenuProperty.NAME_DELIMITER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.model.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("== NameService 테스트 ==")
public class NameServiceTest {
    @ParameterizedTest
    @DisplayName("이름을 잘 분리할 수 있다.")
    @MethodSource("getParseNamesArguments")
    void 이름_분리(List<String> names) {
        List<String> parsedNames = NameService.parseNames(String.join(NAME_DELIMITER, names)).stream()
                .map(Name::toString)
                .collect(Collectors.toList());

        assertIterableEquals(parsedNames, names);
    }

    static Stream<List<String>> getParseNamesArguments() {
        return Stream.of(
                List.of("공룡", "물고기", "강아지", "고양이", "밥먹자"),
                List.of("포비", "뽀로로", "리사"),
                List.of("요술", "토끼")
        );
    }

    @ParameterizedTest
    @DisplayName("이름의 개수가 1개 이하라면 예외를 발생시킬 수 있다.")
    @MethodSource("getTooSmallCoachCountArguments")
    void 이름_개수_적으면_예외(List<String> names) {
        assertThatThrownBy(() -> NameService.parseNames(String.join(NAME_DELIMITER, names)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_SMALL_COACH_COUNT.getMessage());
    }

    static Stream<List<String>> getTooSmallCoachCountArguments() {
        return Stream.of(
                List.of("공룡"),
                List.of("야호!")
                // 빈 경우는 Name에서 먼저 예외가 발생하기 때문에, 테스트하지 않는다.
        );
    }

    @ParameterizedTest
    @DisplayName("이름의 개수가 6개 이상이라면 예외를 발생시킬 수 있다.")
    @MethodSource("getTooLargeCoachCountArguments")
    void 이름_개수_많으면_예외(List<String> names) {
        assertThatThrownBy(() -> NameService.parseNames(String.join(NAME_DELIMITER, names)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_LARGE_COACH_COUNT.getMessage());
    }

    static Stream<List<String>> getTooLargeCoachCountArguments() {
        return Stream.of(
                List.of("안녕", "잘가", "오랜만", "그동안", "수고했어", "배고파"),
                List.of("누구세요", "배고파", "모르겠다", "통과", "해라", "제발", "하이")
        );
    }
}
