package step01;

import org.assertj.core.util.Strings;

import java.util.Objects;

public class Calculator {

    private static final String OPERATOR_REGEX = "[+\\-*/]";
    private static final String NUMBER_REGEX = "(^\\d*)$";

    private static final String SPACE_REGEX = "";

    private static String[] strings;

    private static Integer result;

    public Integer calculate(String input) {
        isEmpty(input);
        strings = input.trim().split(SPACE_REGEX);
        result = Integer.parseInt(strings[0]);
        for (int i = 0; i < strings.length; i++) {
            calculate(i);
        }
        return result;
    }

    void calculate(Integer input) {
        if (isArithmeticOperations(strings[input])) {
            result = Operator.calculate(strings[input], result, Integer.parseInt(strings[input+1]));
        }
    }


    private boolean isArithmeticOperations(String input) {
        return input.matches(OPERATOR_REGEX);
    }

    private boolean isNumber(String input) {
        return input.matches(NUMBER_REGEX);
    }

    private void isEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("empty or null");
        }
    }
}
