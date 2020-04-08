package codingProblems;

import java.util.List;

public class ReverseALinkedList {

    private static ListNode reverseLinkedListIteratively(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
       return prev;
    }

    private static ListNode reverseLinkedListRecursively(ListNode head) {
        ListNode newHead;
        if(head == null || head.next == null )
            return head;

        newHead = reverseLinkedListRecursively(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

//        ListNode.printList(head);
//        ListNode newHead = reverseLinkedListIteratively(head);
//        ListNode.printList(newHead);

        ListNode newHead1 = reverseLinkedListRecursively(head);
        ListNode.printList(newHead1);
    }
}
