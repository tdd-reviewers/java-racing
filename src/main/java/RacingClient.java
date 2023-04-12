import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingClient {

    private static String[] names;
    private static int number;

    public static void main(String[] args) {
        init();
        run();
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputName = scanner.next();
        names = inputName.split(",");
        System.out.println("시도할 회수는 몇 회 인가요?");
        number = scanner.nextInt();
    }

    private static void run() {
        List<RacingCars> cars = new ArrayList<>();
        RandomWrapper random = new RandomWrapper();

        for (int i = 0; i < names.length; i++) {
            RacingCars car = new RacingCars(random, names[i]); // location은 0으로 초기화
            cars.add(car);
        }
        RacingCore racingCore = new RacingCore(cars, number);

        racingCore.run();
    }



}
