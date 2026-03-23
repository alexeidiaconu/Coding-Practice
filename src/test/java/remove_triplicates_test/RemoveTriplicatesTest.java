package remove_triplicates_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import remove_triplicates.RemoveTriplicates;

import java.util.stream.Stream;

public class RemoveTriplicatesTest {

    public RemoveTriplicates removeTriplicates;

    @BeforeEach
    public void init() {
        removeTriplicates = new RemoveTriplicates();
    }

    @ParameterizedTest
    @MethodSource("testRemoveTriplicatesFromStreams")

    public void testRemoveTriplicates(int[] input,int expectedNumber,int[] expectedArray){

        removeTriplicates.initArray(input);
        int nrOfUniqueElements = removeTriplicates.removeTriplicates();

        Assertions.assertArrayEquals(expectedArray,removeTriplicates.elementsArray);
        Assertions.assertEquals(expectedNumber, nrOfUniqueElements);
    }

    public static Stream<Arguments> testRemoveTriplicatesFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{9, 9, 9, 7, 9,9},3,(Object) new int[]{7,9,9}),
                Arguments.of((Object) new int[]{0,0,1,2,2,2,3,3,3,4,2},8,(Object) new int[]{0,0,1,2,2,3,3,4}),
                Arguments.of((Object) new int[]{9, 9, 7, 5, 5, 9},5,(Object) new int[]{5,5,7,9,9}),
                Arguments.of((Object) new int[]{9, 3, 8, 7, 5, 5,3},7,(Object) new int[]{3,3,5,5,7,8,9}),
                Arguments.of((Object) new int[]{0,-1,-2,-2,3,0,4,2},8,(Object) new int[]{-2,-2,-1,0,0,2,3,4})
        );
    }
}

