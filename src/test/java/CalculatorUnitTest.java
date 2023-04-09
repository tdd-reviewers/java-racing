import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorUnitTest {

    Calculator calculator;
    Queue<String> numberQ;
    Queue<String> operatorQ;
    @BeforeEach
    public void setup() {
        numberQ = new LinkedList<>();
        operatorQ = new LinkedList<>();
        calculator = new Calculator(operatorQ, numberQ);
    }
    @Test
    @DisplayName("초기화는 잘 동작할까?")
    public void testInitialize() {
        //when
        calculator.initialize("1 + 2 + 3");

        //then
        Assertions.assertEquals(3, numberQ.size());
        Assertions.assertEquals(2, operatorQ.size());
    }

    @Test
    @DisplayName("process로직을 잘 탈까?")
    public void testProcess() {
        //이 부분은 통합테스트로 대체.
    }

    @Test
    @DisplayName("null 입력이 주어졌을 때, IllegalArgumentException 이 발생할까?")
    public void testValidationWithNullInput() {
        // given
        String input = null;

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.validation(input));
    }

    @Test
    @DisplayName("' ' 공백입력이 주어졌을 때, IllegalArgumentException 이 발생할까?")
    public void testValidationWithBlankInput() {
        // given
        String input = "";

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.validation(input));
    }

    @Test
    @DisplayName("정상 입력이 주어졌을 때, Exception은 발생하지 않을 수 있을까?")
    public void testValidationWithValidInput() {
        // given
        String input = "1 + 2";

        // then
        Assertions.assertDoesNotThrow(() -> calculator.validation(input));
    }

    @ParameterizedTest(name = "{arguments}")
    @DisplayName("두 수의 연산은 올바르게 동작할까?")
    @CsvSource( value= { "1:+:2:3", "5:-:4:1", "1:*:2:2", "2:/:1:2" }, delimiter = ':')
    public void testCalcWithAddition(long a, String op, long b, long expected) {
        // given

        // then
        Assertions.assertEquals(expected, calculator.calc(op, a, b));
    }

    @Test
    @DisplayName("정상 입력이 주어졌을 때, Exception은 발생하지 않을 수 있을까?")
    public void testIllegalOperator() {
        // given
        String op = "#";
        long a = 1;
        long b = 2;

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calc(op, a, b));
    }

    @Test
    @DisplayName("첫번째 호출시에도 getNextValue1은 수를 잘 가져올 수 있을까?")
    public void testFirstCallGetNextValue1() {

        //given

        //when
        calculator.initialize("1 + 2");
        long nextValue1 = calculator.getNextValue1();


        // then
        Assertions.assertEquals(1, nextValue1);
    }

    @Test
    @DisplayName("두번째 호출시에도 getNextValue1은 수를 잘 가져올 수 있을까?")
    public void testSecondCallGetNextValue1() {

        //given

        //when
        numberQ.add("1");
        calculator.getNextValue1();
        // then
        Assertions.assertEquals(0, calculator.getResult());
    }

    @Test
    @DisplayName("nQueue가 비었을때 다음 수를 가져오면 IllegalArgumentException 발생할까?")
    public void test1GetNextValue2() {

        //given
        //when

        // then
        Assertions.assertTrue(numberQ.isEmpty());
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.getNextValue2());
    }
    @Test
    @DisplayName("nQueue가 존재할 때 다음 수를 잘 가져올 수 있을까?")
    public void test2GetNextValue2() {

        //given

        //when
        numberQ.add("1");

        //then
        long nextValue2 = calculator.getNextValue2();
        Assertions.assertEquals(1, nextValue2);
    }

    @ParameterizedTest(name = "{arguments}")
    @DisplayName("isNumeric 은 입력을 잘 구분할 수 있을까?")
    @CsvSource( value= { "1:true", "2:true", "*:false", "/:false" }, delimiter = ':')
    public void testIsNumeric(String input, boolean expected) {

        //given, when

        //then
        Assertions.assertEquals(calculator.isNumeric(input), expected);
    }

    @ParameterizedTest(name = "{arguments}")
    @DisplayName("isOperator 은 입력을 잘 구분할 수 있을까?")
    @CsvSource( value= { "1:false", "2:false", "*:true", "/:true" }, delimiter = ':')
    public void testIsOperator(String input, boolean expected) {

        //given, when

        //then
        Assertions.assertEquals(calculator.isOperator(input), expected);
    }


}