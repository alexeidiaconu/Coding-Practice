package remove_duplicates_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import remove_duplicates.RemoveDuplicates;

import java.util.stream.Stream;

public class RemoveDuplicatesTest {

    public RemoveDuplicates removeDuplicates;

    @BeforeEach
    public void init() {
        removeDuplicates = new RemoveDuplicates();
    }

    @ParameterizedTest
    @MethodSource("testRemoveDuplicatesFromStreams")

    public void testRemoveDuplicates(int[] input,int expectedNumber,int[] expectedArray){

        removeDuplicates.initArray(input);
        int nrOfUniqueElements = removeDuplicates.removeDuplicates();

        Assertions.assertArrayEquals(expectedArray,removeDuplicates.elementsArray);
        Assertions.assertEquals(expectedNumber, nrOfUniqueElements);
    }

    public static Stream<Arguments> testRemoveDuplicatesFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{0,1,2,2,3,0,4,2},5,(Object) new int[]{0,1,2,3,4}),
                Arguments.of((Object) new int[]{9, 3, 8, 7, 5, 5,3},5,(Object) new int[]{3,5,7,8,9}),
                Arguments.of((Object) new int[]{9, 9, 7, 5, 5, 9},3,(Object) new int[]{5, 7, 9}),
                Arguments.of((Object) new int[]{9, 9, 9, 7, 9,9},2,(Object) new int[]{7, 9}),
                Arguments.of((Object) new int[]{0,-1,-2,-2,3,0,4,2},6,(Object) new int[]{-2,-1,0,2,3,4})
        );
    }
}

