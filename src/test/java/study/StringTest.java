package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("분리 테스트")
    void splitTest() {
        assertThat("1,2".split(",")).contains("1");
    }

    @Test
    @DisplayName("'1'을 ','로 split 했을 시 1만을 포함하는 배열 반환")
    void splitNothingTest() {
        String value = "1";
        var expectedResult = new String[]{"1"};
        assertThat(value.split(",")).containsExactly(expectedResult);
    }

    @Test
    @DisplayName("문자열에서 문자 제거 테스트")
    void substringTest() {
        String value = "(1,2)";
        var expectedResult = "1,2";

        assertThat(value.substring(1, value.length()-1)).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("문자열에서 특정 위치 문자 반환 테스트")
    void successGetCharacterTest() {
        String value = "abc";

        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }
}
