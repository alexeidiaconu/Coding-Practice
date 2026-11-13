package randomize_collection_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import randomize_collection.RandomizeCollection;
import randomize_set.RandomizedSet;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class RandomizeCollectionTest {
    private RandomizeCollection randomizeCollection;

    @BeforeEach
    public void setUp() {
        randomizeCollection = new RandomizeCollection();
    }

    @ParameterizedTest
    @MethodSource("insertData")

    public void testInsert(int[] insertValue, boolean[] expected) {

        for (int i = 0; i < insertValue.length; i++) {
            int j = insertValue[i];
            boolean isAdded = expected[i];

            assertEquals(isAdded, randomizeCollection.insert(j));
        }


    }

    @ParameterizedTest
    @MethodSource("removeData")

    public void testRemove(int[] insertValue, boolean[] expected) {

        for (int k : insertValue) {
            if (! randomizeCollection.SearchCollection.containsKey(k)) {
                return;
            }
        }

        for (int i = 0; i < insertValue.length; i++) {
            int j = insertValue[i];
            boolean isRemoved= expected[i];

            assertEquals(isRemoved, randomizeCollection.remove(j));
        }


    }

    static Stream<Arguments> removeData() {

        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7}, (Object) new boolean[]{true, true, true, true, true, true}),
                Arguments.of((Object) new int[]{1, 2, 2, 3, 4, 5, 5, 7}, (Object) new boolean[]{true, true, false, true, true, true, false, true}),
                Arguments.of((Object) new int[]{1, 2, 2, 2, 2}, (Object) new boolean[]{true, true, false, false, false}),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7}, (Object) new boolean[]{true, true, true, true, true, true}
                ));

    }


    static Stream<Arguments> insertData() {

        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 5, 2, 3, 4, 5, 5, 7}, (Object) new boolean[]{true, true, true, false, true, true, false, false, true}),
                Arguments.of((Object) new int[]{1, 2, 2, 2, 2,1}, (Object) new boolean[]{true, true, false, false, false,false}),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7, 1, 2, 3, 4, 5, 7}, (Object) new boolean[]{true, true, true, true, true, true, false, false, false,false, false, false}
                ));

    }

}
