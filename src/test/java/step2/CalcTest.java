package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalcTest {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void input(String input) {
        String[] arr = input.split(" ");
        int latestValue = Integer.parseInt(arr[0]);
        int idx = 1;
        do {
            latestValue = determine(arr[idx], latestValue, Integer.parseInt(arr[idx + 1]));
            idx += 2;
        } while (idx != arr.length);
        System.out.println(latestValue);
    }

    int determine(String operand, int a, int b) {
        return switch (operand) {
            case "+" -> add(a, b);
            case "-" -> subtract(a, b);
            case "*" -> multiply(a, b);
            case "/" -> divide(a, b);
            default ->
                    throw new IllegalArgumentException("Invalid operation. tried: " + operand + "; should be in (+,-,*,/)");
        };
    }

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }


}
