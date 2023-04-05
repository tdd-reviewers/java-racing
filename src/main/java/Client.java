public class Client {
    private final Calculator calculator;

    public Client(Calculator calculator) {
        this.calculator = calculator;
    }

    public String calc(String input) {
        calculator.validation(input);
        calculator.initialize(input);
        calculator.process();
        return printResult();
    }
    private String printResult() {
        long result = calculator.getResult();
        System.out.println(result);
        return String.valueOf(result);
    }
}
