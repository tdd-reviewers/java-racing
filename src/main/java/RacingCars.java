import java.util.Random;

public class RacingCars {

    private final RandomWrapper random;
    private long location = 0;

    public long getLocation() {
        return location;
    }

    RacingCars(RandomWrapper randomWrapper){
        this.random = randomWrapper;
    }

    protected boolean isGo() {
        if (random.nextRandom(10) >= 4) {
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
