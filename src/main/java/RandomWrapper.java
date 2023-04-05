import java.util.Random;

public class RandomWrapper {
    private final Random random;

    public RandomWrapper() {
        this.random = new Random();
    }

    public int nextRandom(int bound) {
        return random.nextInt(bound);
    }
}