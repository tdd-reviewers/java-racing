import java.util.List;
import java.util.StringJoiner;

public class RacingCore {
    private List<RacingCars> racingCars;
    private long count = 0;

    public long getCount() {
        return count;
    }

    public RacingCore(List<RacingCars> racingCars, long count) {
        this.racingCars = racingCars;
        this.count = count;
    }

    public long calcMaxLocation() {
        long maxLocation = -1;
        for (RacingCars car : racingCars) {
            if (car.getLocation() > maxLocation) {
                maxLocation = car.getLocation();
            }
        }

        return maxLocation;
    }

    public void findWinner() {
        StringJoiner winners = new StringJoiner(", ");
        long longDistance = calcMaxLocation();

        racingCars.stream()
            .filter(r -> r.getLocation() == longDistance)
            .map(RacingCars::getName)
            .forEach(winners::add);

        System.out.print(winners+"가 최종 우승했습니다.");
    }


    public void run() {
        System.out.println("실행 결과");
        printResult();
        findWinner();
    }

    private void printResult() {
        while (count > 0) {
            --count;

            racingCars.forEach(i -> {
                i.go();
                i.printResult();
            });

            System.out.println();
        }
    }

}
