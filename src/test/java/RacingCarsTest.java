import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class RacingCarsTest {

    RacingCars racingCars;

    @Mock
    RandomWrapper random;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        racingCars = new RacingCars(random, "noname");
    }

    @Test
    @DisplayName("4 미만의 숫자가 나온다면 False를 반환할까?")
    public void testIsGo() {
        //given: 레이싱카가 준비단계일 때

        //when: 랜덤함수에서 4 미만의 값으로 3이 나온다면?
        Mockito.when(random.nextRandom(10)).thenReturn(3);

        //then: isGo는 False를 리턴해야 한다.
        assertFalse(racingCars.isGo());
    }

    @Test
    @DisplayName("4 이상의 숫자가 나온다면 True를 반환할까?")
    public void testIsGo2() {
        //given: 레이싱카가 준비단계일 때

        //when: 랜덤함수에서 4 미만의 값으로 3이 나온다면?
        Mockito.when(random.nextRandom(10)).thenReturn(4);

        //then: isGo는 False를 리턴해야 한다.
        assertTrue(racingCars.isGo());
    }

    @Test
    @DisplayName("4 이상이 나온 상황에서 출발하면 locaion이 잘 증가할까?")
    public void testGo() {
        //when: 4 이상이 나옴
        Mockito.when(random.nextRandom(10)).thenReturn(4);

        long prev = racingCars.getLocation();
        racingCars.go();
        long next = racingCars.getLocation();

        //then: 증가해야 한다.
        Assertions.assertEquals(next - prev, 1);
    }

    @Test
    @DisplayName("4미만의 나온 상황에서 그대로일까?")
    public void testGo2() {
        //when: 4 이상이 나옴
        Mockito.when(random.nextRandom(10)).thenReturn(3);

        long prev = racingCars.getLocation();
        racingCars.go();
        long next = racingCars.getLocation();

        //then: 증가해야 한다.
        Assertions.assertEquals(next - prev, 0);
    }




}