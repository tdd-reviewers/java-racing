package step01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구 사항 1")
    void splitTest() {
        //test1 : "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        //test2 : "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
        //힌트
        //배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
        //배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.

        String oneTwo = "1,2";
        String one = "1";

        String[] test1 = oneTwo.split(",");
        String[] test2 = one.split(",");

        assertThat(test1).contains("1");
        assertThat(test1).containsExactly("1","2");
        assertThat(test2).contains("1");
    }

    @Test
    @DisplayName("요구 사항 2")
    void substringTest() {
        //"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
        String oneTow = "(1,2)";

        String substring = oneTow.substring(1, oneTow.length() - 1);
        System.out.println(substring);

        assertThat(substring).isEqualTo("1,2");
//        assertThat(substring).isEqualTo("(1,2)");
    }

    @Test
    @DisplayName("요구 사항 3")
    void charAtTest() {
        //"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        // JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
        String abc = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    abc.charAt(5);
                }).withMessageMatching("String index out of range: \\d+");

//        assertThatExceptionOfType(IndexOutOfBoundsException.class)
//                .isThrownBy(() -> {
//                    abc.charAt(5);
//                }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}
