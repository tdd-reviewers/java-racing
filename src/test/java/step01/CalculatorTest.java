package step01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    private Calculator stringCalculate;

    @BeforeEach
    void setup() {
        stringCalculate = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2"})
    @DisplayName("사칙연산 테스트 결과 10 출력")
    void resultTen (String input) {
        Integer result = stringCalculate.calculate(input);
        assertThat(10).isEqualTo(result);
    }


    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사칙연산 예외 테스트")
    void calculateExceptionTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculate.calculate(input))
                .withMessageStartingWith("empty or null");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculate.calculate(input))
                .withMessageStartingWith("empty or null");
    }
}
