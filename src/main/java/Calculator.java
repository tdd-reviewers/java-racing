import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Calculator {
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private long result = 0;
    private long value1 = Long.MIN_VALUE;

    private final Queue<String> opQueue = new LinkedList<>();
    private final Queue<String> nQueue = new LinkedList<>();
    public String calc(String input) {
        validation(input);
        initialize(input);
        process();
        return printResult();
    }
    private void validation(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        if (input.trim().isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void process() {
        while (!nQueue.isEmpty()) {
            String operator = opQueue.poll();
            value1 = getNextValue1();
            long value2 = getNextValue2();
            result = calc(operator, value1, value2);
        }
    }

    private long calc(String operator, long a, long b) {
        if (Objects.equals(operator, ADD)) {
            return a + b;
        }

        if (Objects.equals(operator, SUBTRACT)) {
            return a - b;
        }

        if (Objects.equals(operator, DIVIDE)) {
            return a / b;
        }

        if (Objects.equals(operator, MULTIPLY)) {
            return a * b;
        }

        throw new IllegalArgumentException();
    }

    private long getNextValue1() {
        if (value1 == Long.MIN_VALUE && !nQueue.isEmpty()){
            return Long.parseLong(nQueue.poll());
        }

        return result;
    }

    private long getNextValue2() {
        if (nQueue.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return Long.parseLong(nQueue.poll());
    }

    private void initialize(String input) {
        String[] parsedInputs = input.split(" ");

        for (String parsedInput : parsedInputs) {
            if (isOperator(parsedInput)) {
                opQueue.add(parsedInput);
                continue;
            }

            nQueue.add(parsedInput);
        }
    }

    private boolean isOperator(String c) {
        return !isNumeric(c);
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    private String printResult() {
        System.out.println(result);
        return String.valueOf(result);
    }
}
