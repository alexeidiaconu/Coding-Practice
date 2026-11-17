package link_list_random_node_test;

import linked_list_random_node.LinkedListRandomNode;
import linked_list_random_node.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static junit.framework.Assert.assertTrue;


public class LinkedListRandomNodeTest {

    ListNode headNode;
    LinkedListRandomNode linkedListRandomNode;

    @BeforeEach
    public void setLinkedListRandomNode() {
//        int firstVal = (int)(10 * Math.random());
//        headNode = new ListNode();
//        linkedListRandomNode = new LinkedListRandomNode(headNode);
    }

    @ParameterizedTest
    @MethodSource("listOfElements")
    public void getRandomTest (int[] insertValue) {
        headNode = new ListNode(insertValue[0]);
        if (headNode == null) {
            return;
        }

        for (int i = 1; i < insertValue.length; i++) {
            headNode = new ListNode(insertValue[i],headNode);
            if (headNode == null) {
                return;
            }
        }

        linkedListRandomNode = new LinkedListRandomNode(headNode);

        int randomValue = linkedListRandomNode.getRandom();
        boolean isInTheList = false;

        for(int element : insertValue) {

            if (randomValue == element) {
                isInTheList = true;
                break;
            }
        }
        assertTrue(isInTheList);
    }


    static Stream<Arguments> listOfElements() {

        return Stream.of(
                Arguments.of((Object) new int[]{1, 1, 1, 1}),
                Arguments.of((Object) new int[]{1, 2, 2, 2, 2}),
                Arguments.of((Object) new int[]{1, 2, 3, 4, 5, 7}
                ));

    }

}
