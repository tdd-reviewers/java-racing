import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class RacingCoreTest {

    RacingCore racingCore;

    @Mock
    RacingCars racingCar1;

    @Mock
    RacingCars racingCar2;

    @Mock
    RacingCars racingCar3;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        racingCore = new RacingCore(List.of(racingCar1, racingCar2, racingCar3), 5);
    }

    @Test
    @DisplayName("종료되고나서 요청된 횟수만큼 실행이 될까?")
    void testRun() {

        //Given: 프로그램이 실행된 후

        //When 정상적으로 프로그램이 종료되었다면
        racingCore.run();

        //Then tryCount는 0 이어야 한다.
        Assertions.assertEquals(racingCore.getCount(), 0);
        Mockito.verify(racingCar1, times(5)).go();
    }


    @ParameterizedTest(name = "input: {arguments} |  result: {3}")
    @DisplayName("최대거리를 간 Car의 위치를 잘 얻을 수 있을까?")
    @CsvSource( value= { "1:2:3:3", "4:10:5:10", "9:5:1:9" }, delimiter = ':')
    public void testCalcMaxLocation(long a, long b, long c, long expected) {
        Mockito.when(racingCar1.getLocation()).thenReturn(a);
        Mockito.when(racingCar2.getLocation()).thenReturn(b);
        Mockito.when(racingCar3.getLocation()).thenReturn(c);
        long l = racingCore.calcMaxLocation();
        Assertions.assertEquals(l, expected);

        Mockito.verify(racingCar1, atLeast(1)).getLocation();
    }

    public void testFindWinner()  {
        //..흠.....
    }
}