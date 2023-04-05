import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingClient {

    private static int carCount;
    private static int number;

    public static void main(String[] args) {
        init();
        run();
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        number = scanner.nextInt();
    }

    private static void run() {
        List<RacingCars> cars = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < carCount; i++) {
            RacingCars car = new RacingCars(random); // location은 0으로 초기화
            cars.add(car);
        }
        RacingCore racingCore = new RacingCore(cars, number);

        racingCore.run();
    }



}
