import java.util.Random;

public class RacingCars {

    private final RandomWrapper random;
    private String name;
    private long location;

    public long getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    RacingCars(RandomWrapper random, String name) {
        this.random = random;
        this.name = name;
        this.location = 0;
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
        System.out.print(this.name + " : ");
        for (long i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
