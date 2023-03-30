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
    void splitV2Test() {
        String value = "1";
        var targetValue = new String[]{"1"};
        assertThat(value.split(",")).isEqualTo(targetValue);
    }
}
