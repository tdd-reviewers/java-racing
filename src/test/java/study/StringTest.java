package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("분리 테스트")
    void splitTest() {
        Assertions.assertThat("1,2".split(",")).contains("1");
    }
}
