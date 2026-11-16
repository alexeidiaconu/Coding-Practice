package linked_list_random_node;


import java.util.Random;


public class LinkedListRandomNode {
    ListNode listHead;
    Random random;

    public LinkedListRandomNode(ListNode head) {
        this.listHead = head;
        this.random = new Random();
    }



    Integer getRandom() {
        int count = 0;
        int result = 0;
        ListNode current = this.listHead;

        while (current != null) {
            count++;
            int chooseThisOne = random.nextInt(count);
            if (chooseThisOne == 0) {
                result = current.value;
            }
            current = current.nextNode;

        }
        System.out.println("Chosen Value: " + result);
        return result;
    }


}