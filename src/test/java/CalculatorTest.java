import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.LinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//1. 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
//2. 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
//3. 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.

/**
 * 통합테스트
 */
class CalculatorTest {

    Calculator calculator = new Calculator(new LinkedList<>(), new LinkedList<>());
    Client client = new Client(calculator);

    @Test
    @DisplayName("예상치 못한 입력에도 에러가 잘 발생할까?")
    void dirtyInputTest1() {
        String dirtyInput = "";
        assertThatThrownBy(() -> client.calc(dirtyInput))
            .isInstanceOf(IllegalArgumentException.class);

        String dirtyInput2 = " ";
        assertThatThrownBy(() -> client.calc(dirtyInput2))
            .isInstanceOf(IllegalArgumentException.class);

        String dirtyInput3 = "  ";
        assertThatThrownBy(() -> client.calc(dirtyInput3))
            .isInstanceOf(IllegalArgumentException.class);

        String dirtyInput4 = null;
        assertThatThrownBy(() -> client.calc(dirtyInput4))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest(name = "{arguments} Case")
    @DisplayName("두 수의 덧셈은 잘 동작할까?")
    @CsvSource( value= { "1 + 2:3", "0 + 1:1", "3 + 5:8" }, delimiter = ':')
    void plusBaseTest(String input, String result) {
        //given: input이 입력되고

        //when: 계산했을 때
        String calcResult = client.calc(input);

        //then: result 결과와 같아야 한다.
        Assertions.assertThat(calcResult).isEqualTo(result);
    }

    @ParameterizedTest(name = "{arguments} Case")
    @DisplayName("세 수의 덧셈은 잘 동작할까?")
    @CsvSource( value= { "1 + 2 + 3:6", "0 + 1 + 2:3", "3 + 5 + 1:9" }, delimiter = ':')
    void plusAdvancedTest(String input, String result) {
        //given: input이 입력되고

        //when: 계산했을 때
        String calcResult = client.calc(input);

        //then: result 결과와 같아야 한다.
        Assertions.assertThat(calcResult).isEqualTo(result);
    }

    @ParameterizedTest(name = "{arguments} Case")
    @DisplayName("두 수의 뺄셈은 잘 동작할까?")
    @CsvSource( value= { "2 - 1:1", "9 - 0:9", "5 - 2:3" }, delimiter = ':')
    void minusBaseTest(String input, String result) {
        //given: input이 입력되고

        //when: 계산했을 때
        String calcResult = client.calc(input);

        //then: result 결과와 같아야 한다.
        Assertions.assertThat(calcResult).isEqualTo(result);
    }

    @ParameterizedTest(name = "{arguments} Case")
    @DisplayName("세 수의 뺄셈은 잘 동작할까?")
    @CsvSource( value= { "2 - 1 - 1:0", "9 - 0 - 0:9", "5 - 2 - 2:1" }, delimiter = ':')
    void minusAdvancedTest(String input, String result) {
        //given: input이 입력되고

        //when: 계산했을 때
        String calcResult = client.calc(input);

        //then: result 결과와 같아야 한다.
        Assertions.assertThat(calcResult).isEqualTo(result);
    }

    @ParameterizedTest(name = "{arguments} Case")
    @DisplayName("두 수의 곱셈은 잘 동작할까?")
    @CsvSource( value= { "1 * 2:2", "2 * 3:6", "3 * 4:12" }, delimiter = ':')
    void multipleBaseTest(String input, String result) {
        //given: input이 입력되고

        //when: 계산했을 때
        String calcResult = client.calc(input);

        //then: result 결과와 같아야 한다.
        Assertions.assertThat(calcResult).isEqualTo(result);
    }

    @ParameterizedTest(name = "{arguments} Case")
    @DisplayName("세 수의 곱셈은 잘 동작할까?")
    @CsvSource( value= { "1 * 2 * 3:6", "2 * 3 * 2:12", "3 * 4 * 5:60" }, delimiter = ':')
    void multipleAdvancedTest(String input, String result) {
        //given: input이 입력되고

        //when: 계산했을 때
        String calcResult = client.calc(input);

        //then: result 결과와 같아야 한다.
        Assertions.assertThat(calcResult).isEqualTo(result);
    }



    @ParameterizedTest(name = "{arguments} Case")
    @DisplayName("두 수의 나눗셈은 잘 동작할까?")
    @CsvSource( value= { "5 / 1:5", "6 / 2:3", "10 / 5:2" }, delimiter = ':')
    void divideBaseTest(String input, String result) {
        //given: input이 입력되고

        //when: 계산했을 때
        String calcResult = client.calc(input);

        //then: result 결과와 같아야 한다.
        Assertions.assertThat(calcResult).isEqualTo(result);
    }

    @ParameterizedTest(name = "{arguments} Case")
    @DisplayName("세 수의 나눗셈은 잘 동작할까?")
    @CsvSource( value= { "5 / 1 / 5:1", "6 / 2 / 3:1", "10 / 1/ 1:10" }, delimiter = ':')
    void divideAdvancedTest(String input, String result) {
        //given: input이 입력되고

        //when: 계산했을 때
        String calcResult = client.calc(input);

        //then: result 결과와 같아야 한다.
        Assertions.assertThat(calcResult).isEqualTo(result);
    }

    @ParameterizedTest(name = "{arguments} Case")
    @DisplayName("복합연산은 잘 동작할까?")
    @CsvSource( value= { "1 + 2 - 3 * 6 / 6:0","1 + 1 / 2 + 1 + 3:5", "2 + 3 * 4 / 2:10"}, delimiter = ':')
    void confuseCaseTest(String input, String result) {
        //given: input이 입력되고

        //when: 계산했을 때
        String calcResult = client.calc(input);

        //then: result 결과와 같아야 한다.
        Assertions.assertThat(calcResult).isEqualTo(result);
    }
}