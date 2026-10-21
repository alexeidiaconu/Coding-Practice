package majority_element_test;

import majority_element.MajorityElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MajorityElementTest {

    MajorityElement majorityElement;


    @BeforeEach
    public void init() {
        majorityElement = new MajorityElement();
    }

    @ParameterizedTest
    @MethodSource("testMajorityElementFromStreams")

    public void testMajorityElement(int[] testArray, int expectedElement) {

        majorityElement.initArray(testArray);
//        int actualElement = majorityElement.findMajorityElement();

        Assertions.assertEquals(expectedElement,majorityElement.findMajorityElement());

    }

    @ParameterizedTest
    @MethodSource("testHIndexFromStreams")

    public void testHIndex(int[] testArray, int expectedHIndex) {

        majorityElement.initArray(testArray);

        Assertions.assertEquals(expectedHIndex,majorityElement.findHIndex());

    }


    public static Stream<Arguments> testMajorityElementFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{9, 9, 7, 5, 5, 9, 9},9),
                Arguments.of((Object) new int[]{9, 9, 9, 7, 9,9},9),
                Arguments.of((Object) new int[]{0, 0, 1, 2, 2, 2, 3, 3, 3, 4, 2, 2},2),
                Arguments.of((Object) new int[]{9, 3, 8, 7, 5, 5, 3, 5, 5},5),
                Arguments.of((Object) new int[]{0, -1, -2, -2, 3, 0, 4, -2, -2},-2)
        );
    }

    public static Stream<Arguments> testHIndexFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{9, 9, 9, 7, 9,9},6),
                Arguments.of((Object) new int[]{9, 9, 7, 5, 5, 9, 9},5),
                Arguments.of((Object) new int[]{3,0,6,1,5},3),
                Arguments.of((Object) new int[]{0, 0, 1, 2, 2, 2, 3, 3, 3, 4, 2, 2},3),
                Arguments.of((Object) new int[]{9, 3, 8, 7, 5, 5, 3, 5, 5},5),
                Arguments.of((Object) new int[]{0, 1, 2, 2, 3, 0, 4, 2, 2},2)
        );
    }

}
