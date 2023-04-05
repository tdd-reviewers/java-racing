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

    private final Queue<String> opQueue;
    private final Queue<String> nQueue;

    public Calculator(Queue<String> opQueue, Queue<String> nQueue) {
        this.opQueue = opQueue;
        this.nQueue = nQueue;
    }

    protected void initialize(String input) {
        String[] parsedInputs = input.split(" ");

        for (String parsedInput : parsedInputs) {
            if (isOperator(parsedInput)) {
                opQueue.add(parsedInput);
                continue;
            }

            nQueue.add(parsedInput);
        }
    }

    protected void process() {
        while (!nQueue.isEmpty()) {
            String operator = opQueue.poll();
            value1 = getNextValue1();
            long value2 = getNextValue2();
            result = calc(operator, value1, value2);
        }
    }

    protected long getResult() {
        return result;
    }

    protected void validation(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        if (input.trim().isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    protected long calc(String operator, long a, long b) {
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

    protected long getNextValue1() {
        if (value1 == Long.MIN_VALUE && !nQueue.isEmpty()){
            return Long.parseLong(nQueue.poll());
        }

        return result;
    }

    protected long getNextValue2() {
        if (nQueue.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return Long.parseLong(nQueue.poll());
    }

    protected boolean isOperator(String c) {
        return !isNumeric(c);
    }

    public boolean isNumeric(String str) {

        try {
            Double.parseDouble(str);
        } catch (Exception nfe) {
            return false;
        }
        return true;
    }
}
