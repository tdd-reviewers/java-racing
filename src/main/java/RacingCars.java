import java.util.Random;

public class RacingCars {

    private final Random random;
    private long location = 0;


    RacingCars(Random random){
        this.random = random;
    }

    protected boolean isGo() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            return true;
        }

        return false;
    }


    protected void go() {
        if (isGo()) {
            location++;
        }
    }

    protected void printResult() {
        System.out.print("|");
        for (long i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
