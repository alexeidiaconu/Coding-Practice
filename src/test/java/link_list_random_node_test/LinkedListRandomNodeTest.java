package link_list_random_node_test;

import linked_list_random_node.LinkedListRandomNode;
import linked_list_random_node.ListNode;
import org.junit.jupiter.api.BeforeEach;


public class LinkedListRandomNodeTest {

    ListNode headNode;
    LinkedListRandomNode linkedListRandomNode;

    @BeforeEach
    public void setLinkedListRandomNode() {
        int firstVal = (int)(10 * Math.random());
        headNode = new ListNode(firstVal);
        linkedListRandomNode = new LinkedListRandomNode(headNode);
    }
}
