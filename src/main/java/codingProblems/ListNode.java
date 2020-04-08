package codingProblems;

public class ListNode {


    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }

    public static void printList(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

}
