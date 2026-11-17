package linked_list_random_node;

public class ListNode {

    public ListNode nextNode;
    int value;

    public ListNode() {}

    public ListNode(int val) {

        this.value = val;
    }

    public ListNode(int val, ListNode next) {
        this.value = val;
        this.nextNode = next;
    }



}
