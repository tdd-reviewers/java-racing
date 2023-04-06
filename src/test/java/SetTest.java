import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void contains() {
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    public void test1() {
        assertThat(numbers).isNotEmpty();
        // set은 중복을 허용하지 않으므로 3개가 들어있어야 정상임.
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.size()).isNotEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.")
    public void test2_1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.")
    public void test2_2(int input) {
        assertThat(numbers.contains(input)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.")
    void contains_v2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
