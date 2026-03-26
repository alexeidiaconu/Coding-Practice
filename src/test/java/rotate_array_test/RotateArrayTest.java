package rotate_array_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import rotate_array.RotateArray;

import java.util.stream.Stream;

public class RotateArrayTest {

    RotateArray rotateArray;

    @BeforeEach
    public void init() {
        rotateArray =  new RotateArray();
    }

    @ParameterizedTest
    @MethodSource("testRotateArrayFromStreams")

    public void testRotateArray(int[] initialArray, int steps, int[] expectedArray){

        rotateArray.initArray(initialArray);
        rotateArray.rotateArray(steps);

        Assertions.assertArrayEquals(expectedArray,rotateArray.elementsArray);
    }

    public static Stream<Arguments> testRotateArrayFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{9, 9, 7, 5, 5, 9, 9}, 2, (Object) new int[]{9, 9, 9, 9, 7, 5, 5}),
                Arguments.of((Object) new int[]{9, 9, 9, 7, 9,9}, 3, (Object) new int[]{7, 9, 9, 9, 9, 9}),
                Arguments.of((Object) new int[]{0, 0, 1, 2, 2, 2, 3, 3, 3, 4, 2, 2}, 5 ,(Object) new int[]{3, 3, 4, 2, 2, 0, 0, 1, 2, 2, 2, 3}),
                Arguments.of((Object) new int[]{9, 3, 8, 7, 5, 5, 3, 5, 5}, 5, (Object) new int[]{5, 5, 3, 5, 5, 9, 3, 8, 7}),
                Arguments.of((Object) new int[]{0, -1, -2, -2, 3, 0, 4, -2, -2}, 4, (Object) new int[]{0, 4, -2, -2, 0, -1, -2, -2, 3})
        );
    }
}
