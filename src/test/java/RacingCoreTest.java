import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class RacingCoreTest {

    RacingCore racingCore;

    @Mock
    RacingCars racingCars;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        racingCore = new RacingCore(List.of(racingCars), 5);
    }

    @Test
    @DisplayName("종료되고나서 요청된 횟수만큼 실행이 될까?")
    void testRun() {

        //Given: 프로그램이 실행된 후

        //When 정상적으로 프로그램이 종료되었다면
        racingCore.run();

        //Then tryCount는 0 이어야 한다.
        Assertions.assertEquals(racingCore.getCount(), 0);
        Mockito.verify(racingCars, times(5)).go();
    }
}