package remove_element_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import remove_element.RemoveElement;

import java.util.stream.Stream;

public class RemoveElementTest {

    public RemoveElement removeElement;



    @BeforeEach
    public void init () {
        removeElement = new RemoveElement();
    }

    @ParameterizedTest
    @MethodSource("testInitArrayFromStreams")

    public void testInitElements(int[] elements) {
        removeElement.initElements(elements);

        Assertions.assertArrayEquals(elements, removeElement.elementArray);
    }


    private static Stream<Arguments> testInitArrayFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{9, 8, 7, 5, 5,3}),
                Arguments.of((Object) new int[]{3,5,7,8,9}),
                Arguments.of((Object) new int[]{9, 3, 5, 7, 8})
        );
    }

    @ParameterizedTest
    @MethodSource("testRemoveElementFromStreams")

    public void testRemoveElement (int[] elementsArray, int element, int expectedNumber,int[]expectedArray) {
        removeElement.initElements(elementsArray);
        int numberOfElements =  removeElement.removeElement(element);

        Assertions.assertArrayEquals(expectedArray, removeElement.elementArray);
        Assertions.assertEquals(numberOfElements,expectedNumber);
    }

    public static Stream<Arguments> testRemoveElementFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{0,1,2,2,3,0,4,2},2,3,(Object) new int[]{0,1,3,0,4,-1,-1,-1}),
                Arguments.of((Object) new int[]{9, 8, 7, 5, 5,3},5,2,(Object) new int[]{9, 8, 7, 3, -1,-1}),
                Arguments.of((Object) new int[]{9, 9, 7, 5, 5,9},9,3,(Object) new int[]{7, 5, 5, -1, -1,-1}),
                Arguments.of((Object) new int[]{9, 9, 9, 7, 9,9},9,5,(Object) new int[]{7, -1, -1,-1, -1,-1})
        );
    }
}
