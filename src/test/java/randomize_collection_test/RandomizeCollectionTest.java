package randomize_collection_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import randomize_collection.RandomizedCollection;
import randomize_collection.RandomizedCollection;

import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class RandomizeCollectionTest {
    private RandomizedCollection randomizedCollection;

    @BeforeEach
    public void setUp() {
        randomizedCollection = new RandomizedCollection();
    }

    @ParameterizedTest
    @MethodSource("insertData")

    public void testInsert(int[] insertValue, boolean[] expected) {

        for (int i = 0; i < insertValue.length; i++) {
            int j = insertValue[i];
            boolean isAdded = expected[i];

            assertEquals(isAdded, randomizedCollection.insert(j));
        }


    }

    @ParameterizedTest
    @MethodSource("removeData")

    public void testRemove(int[] insertValue, boolean[] expected) {

        for (int k : insertValue) {
            if (! randomizedCollection.insert(k)) {
                return;
            }
        }

        for (int i = 0; i < insertValue.length; i++) {
            int j = insertValue[i];
            boolean isRemoved= expected[i];

            assertEquals(isRemoved, randomizedCollection.remove(j));
        }


    }

    @ParameterizedTest
    @MethodSource("randomData")
    public void testRandomize(int[] insertValue) {

        for (int k : insertValue) {
            if (! randomizedCollection.insert(k)) {
                return;
            }
        }
        int expectedIndex = 0;
        while (!randomizedCollection.ArraySet.isEmpty()) {
            boolean existsInSet = false;
            int random = randomizedCollection.getRandom();

            for (int element :randomizedCollection.ArraySet) {
                if (random == element) {
                    existsInSet = true;
                    randomizedCollection.remove(element);
                    break;
                }
            }
            assertTrue(existsInSet);
            expectedIndex++;
        }

    }

    static Stream<Arguments> randomData() {

        return Stream.of(
                Arguments.of((Object) new int[]{1, 2}),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7, 3, 5, 8, 9}),
                Arguments.of((Object) new int[]{1, 2, 8, 9, 3, 6})
        );

    }

    static Stream<Arguments> removeData() {

        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7}, (Object) new boolean[]{true, true, true, true, true, true}),
                Arguments.of((Object) new int[]{1, 1, 2, 5, 2, 3, 4, 5, 5, 7}, (Object) new boolean[]{true, false, true, true, true, true, true, true, true, true}),
                Arguments.of((Object) new int[]{1, 2, 2, 3, 4, 5, 5, 7}, (Object) new boolean[]{true, true, false, true, true, true, false, true}),
                Arguments.of((Object) new int[]{1, 2, 2, 2, 2}, (Object) new boolean[]{true, true, false, false, false})
                                );

    }


    static Stream<Arguments> insertData() {

        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 5, 2, 3, 4, 5, 5, 7}, (Object) new boolean[]{true, true, true, false, true, true, false, false, true}),
                Arguments.of((Object) new int[]{1, 2, 2, 2, 2,1}, (Object) new boolean[]{true, true, false, false, false,false}),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7, 1, 2, 3, 4, 5, 7}, (Object) new boolean[]{true, true, true, true, true, true, false, false, false,false, false, false}
                ));

    }

}
