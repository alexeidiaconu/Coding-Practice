package randomize_set_test;
import merge_two_arrays.MergeTwoArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import randomize_set.RandomizedSet;

import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class RandomizeSetTest {
    private RandomizedSet randomizedSet;


    @BeforeEach
    public void setUp() {
        randomizedSet = new RandomizedSet();
    }

    @ParameterizedTest
    @MethodSource("insertData")

//    int[] ints = {1,2,2,3,4,5,5,7};
//    boolean[] expected = {true,true,false,true,true,false,true};

    public void testInsert(int[] insertValue, boolean[] expected) {

        for (int i = 0; i < insertValue.length; i++) {
            int j = insertValue[i];
            boolean isAdded = expected[i];

            assertEquals(isAdded, randomizedSet.insert(j));
        }


    }
    @ParameterizedTest
    @MethodSource("removeData")

    public void testRemove(int[] insertValue, boolean[] expected) {

        for (int k : insertValue) {
            if (! randomizedSet.insert(k)) {
                return;
            }
        }

        for (int i = 0; i < insertValue.length; i++) {
            int j = insertValue[i];
            boolean isRemoved= expected[i];

            assertEquals(isRemoved, randomizedSet.remove(j));
        }


    }

    @ParameterizedTest
    @MethodSource("randomData")
    public void testRandomize(int[] insertValue) {

        for (int k : insertValue) {
            if (! randomizedSet.insert(k)) {
                return;
            }
        }
        int expectedIndex = 0;
        while (!randomizedSet.ArraySet.isEmpty()) {
            boolean existsInSet = false;
            int random = randomizedSet.getRandom();

            for (int element :randomizedSet.ArraySet) {
                if (random == element) {
                    existsInSet = true;
                    randomizedSet.remove(element);
                    break;
                }
            }
            assertTrue(existsInSet);
            expectedIndex++;
        }

    }


    static Stream<Arguments> insertData() {

        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 2, 3, 4, 5, 5, 7}, (Object) new boolean[]{true, true, false, true, true, true, false, true}),
                Arguments.of((Object) new int[]{1, 2, 2, 2, 2}, (Object) new boolean[]{true, true, false, false, false}),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7}, (Object) new boolean[]{true, true, true, true, true, true}
                ));

    }

    static Stream<Arguments> removeData() {

        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7}, (Object) new boolean[]{true, true, true, true, true, true}),
                Arguments.of((Object) new int[]{1, 2, 2, 3, 4, 5, 5, 7}, (Object) new boolean[]{true, true, false, true, true, true, false, true}),
                Arguments.of((Object) new int[]{1, 2, 2, 2, 2}, (Object) new boolean[]{true, true, false, false, false}),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7}, (Object) new boolean[]{true, true, true, true, true, true}
                ));

    }

    static Stream<Arguments> randomData() {

        return Stream.of(
                Arguments.of((Object) new int[]{1, 2}),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7}),
                Arguments.of((Object) new int[]{1, 2, 8, 9, 3, 6})
        );

    }

}
