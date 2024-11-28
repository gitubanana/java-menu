package menu.model;

import static menu.constant.ErrorMessage.TOO_LONG_NAME;
import static menu.constant.ErrorMessage.TOO_SHORT_NAME;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("== Name 테스트 ==")
public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "1", "2"})
    @DisplayName("이름의 길이가 2보다 작을 경우 예외를 발생시킬 수 있다.")
    void 길이가_작으면_예외(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_SHORT_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나다라마바사", "아자차카타파하", "abcdef"})
    @DisplayName("이름의 길이가 5보다 클 경우 예외를 발생시킬 수 있다.")
    void 길이가_크면_예외(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_LONG_NAME.getMessage());
    }
}
