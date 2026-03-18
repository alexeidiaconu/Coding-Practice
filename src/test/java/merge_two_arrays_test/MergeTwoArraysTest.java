package merge_two_arrays_test;
import merge_two_arrays.MergeTwoArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MergeTwoArraysTest {
    private MergeTwoArrays mergeTwoArrays;



    @BeforeEach
    public void init() {
        mergeTwoArrays = new MergeTwoArrays();
    }

    @ParameterizedTest

    @MethodSource({"testArrayFromStreams"})

    public void testBubleSortArray(int[] arrToTest) {
        int[] expected = {3,5,7,8,9};
        mergeTwoArrays.bubleSortArray(arrToTest);
        Assertions.assertArrayEquals(arrToTest,expected);

    }

    private static Stream<Arguments> testArrayFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{9, 8, 7, 5, 3}),
                Arguments.of((Object) new int[]{3,5,7,8,9}),
                Arguments.of((Object) new int[]{9, 3, 5, 7, 8})


        );
    }
    @ParameterizedTest

    @MethodSource({"InitArrayFromStreams"})

    public void testInitArray(int[] a1,int[] a2, int nrElem1, int nrElem2){

        mergeTwoArrays.initArrays(a1,a2,nrElem1, nrElem2);

        Assertions.assertArrayEquals(a1,mergeTwoArrays.arr1);
        Assertions.assertArrayEquals(a2,mergeTwoArrays.arr2);

    }

    public static Stream<Arguments> InitArrayFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{9, 8, 7, 5, 3,0,0,0},(Object) new int[]{9,3,7},5,3),
                Arguments.of((Object) new int[]{3,5,7,8,9,0,0,0},(Object) new int[]{9,7,3},5,3),
                Arguments.of((Object) new int[]{9, 3, 5, 7, 8,0,0,0},(Object) new int[]{3,9,7},5,3)
        );
    }

    @ParameterizedTest

    @MethodSource({"MergeArrayFromStreams"})

    public void testMergeArrays(int[] a1,int[] a2, int nrElem1, int nrElem2,int[] expected){
        mergeTwoArrays.initArrays(a1,a2,nrElem1,nrElem2);
        mergeTwoArrays.mergeArrays();
        Assertions.assertArrayEquals(expected,mergeTwoArrays.arr1);
    }

    public static Stream<Arguments> MergeArrayFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{9, 8, 7, 5, 3,0,0,0},(Object) new int[]{9,3,7},5,3,(Object) new int[]{3,3,5, 7, 7,8,9,9}),
                Arguments.of((Object) new int[]{3,5,7,8,9,0,0,0},(Object) new int[]{4,19,6},5,3,(Object) new int[]{3,4,5,6,7,8,9,19}),
                Arguments.of((Object) new int[]{9, 3, 5, 7, 8,0,0,0},(Object) new int[]{-3,19,17},5,3,(Object) new int[]{-3,3,5,7,8,9,17,19})
        );
    }


}
