import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("Set은 숫자를 잘 반활할까?")
    void case1() {
        //given

        //when
        int size = numbers.size();

        //then
        Assertions.assertThat(size).isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("Set은 사이즈를 정확하게 반환할까?")
    void case1_1() {
        //given
        //SET에는 3개의 숫자가 들어있다.

        //when
        int size = numbers.size();

        //then
        Assertions.assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "{arguments}, Exists")
    @DisplayName("Set에 아래의 값들이 있을까?")
    @ValueSource(ints = { 1, 2, 3 })
    void case2(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest(name = "{arguments}, Not Exists")
    @DisplayName("Set에 아래의 값들이 없을까?")
    @ValueSource(ints = { 0, 5, 6 })
    void case3(int value) {
        assertThat(numbers.contains(value)).isFalse();
    }

    @ParameterizedTest(name = "{arguments}, Not Exists")
    @DisplayName("Set에 아래의 값들이 없음을 판단할 수 있을까?")
    @CsvSource( value= { "1:false", "4:false", "5:false" }, delimiter = ':')
    void case4(String value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }




    // Test Case 구현

}
