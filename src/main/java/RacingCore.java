import java.util.List;
import java.util.Scanner;

public class RacingCore {
    private List<RacingCars> racingCars;
    private long count = 0;

    public RacingCore(List<RacingCars> racingCars, long count) {
        this.racingCars = racingCars;
        this.count = count;
    }

    public void run() {
        System.out.println("실행 결과");
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
