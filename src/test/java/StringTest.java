import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    public void test1_1() {
        String input = "1,2";
        String[] arrInput = input.split(",");

        assertThat(arrInput.length).isEqualTo(2);
        assertThat(arrInput).contains("1");
        assertThat(arrInput).contains("2");
        assertThat(arrInput).doesNotContain("3", "4");
        assertThat(arrInput).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void test1_2() {
        String input = "1,";
        String[] arrInput = input.split(",");

        assertThat(arrInput.length).isEqualTo(1);
        assertThat(arrInput).contains("1");
        assertThat(arrInput).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    public void test2() {
        String input = "(1,2)";
        String stripedInput = input.substring(1, input.length() - 1);

        assertThat(stripedInput).doesNotContain("(", ")");
        assertThat(stripedInput).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    public void test3() {
        String input = "abc";

        // a를 가져온다
        assertThat(input.charAt(0)).isEqualTo('a');

        // b를 가져온다
        assertThat(input.charAt(1)).isEqualTo('b');

        // c를 가져온다
        assertThat(input.charAt(2)).isEqualTo('c');

        // StringIndexOutOfBoundsException 가 발생하는지 확인한다
        assertThatThrownBy(() -> input.charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class);

    }
}
