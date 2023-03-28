import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
public class StringClassTest {

    @Test
    @DisplayName("Split 메소드가 2개이상 콤마로 이어진 스트링을 파싱할 수 있을까?")
    void case1() {

        //given
        String input = "1,2";

        //when
        String[] split = input.split(",");

        //then
        Assertions.assertThat(split.length).isEqualTo(2);
        Assertions.assertThat(split).contains("1", "2");
        Assertions.assertThat(split).doesNotContain("3");
    }

    @Test
    @DisplayName("Split 메소드의 콤마로 이어지지 않는 String을 파싱할 수 있을까")
    void case2() {
        //given
        String input = "1";

        //when
        String[] split = input.split(",");

        //then
        Assertions.assertThat(split.length).isEqualTo(input.length());
        Assertions.assertThat(split).contains(input);
        Assertions.assertThat(split).containsExactly(input);
    }

    @Test
    @DisplayName("substring으로 (,) 문자를 제거하고 1,2를 남겨둘 수 있을까?")
    void case3() {
        //given
        String input = "(1,2)";

        //when
        String substr = input.substring(1, input.length() - 1);

        //then
        Assertions.assertThat(substr).isEqualTo("1,2");
        Assertions.assertThat(substr).doesNotContain("(", ")");
    }

    @Test
    @DisplayName("substring으로 범위를 벗어난 접근에 대해서 StringIndexOutOfBoundsException 이벤트가 발생할 수 있을까?")
    void case4() {
        //given
        String input = "(1,2)";

        //when
        assertThatThrownBy(() -> input.substring(1, 10))
            .isInstanceOf(IndexOutOfBoundsException.class); //then
    }

    @Test
    @DisplayName("charAt이 범위를 벗어난 접근에 대해서 StringIndexOutOfBoundsException 이벤트가 발생할 수 있을까?")
    void case5() {
        //given
        String input = "abc";

        //when
        assertThatThrownBy(() -> input.charAt(100))
            .isInstanceOf(IndexOutOfBoundsException.class); //then
    }

    @Test
    @DisplayName("charAt이 특정위치의 문자를 잘 가져올 수 있을까?")
    void case6() {
        //given
        String input = "abc";

        //when
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);

        Assertions.assertThat(first).isEqualTo('a');
        Assertions.assertThat(second).isEqualTo('b');
        Assertions.assertThat(third).isEqualTo('c');

        char[] chars = input.toCharArray();
        Assertions.assertThat(first).isEqualTo(chars[0]);
        Assertions.assertThat(second).isEqualTo(chars[1]);
        Assertions.assertThat(third).isEqualTo(chars[2]);
    }


}
