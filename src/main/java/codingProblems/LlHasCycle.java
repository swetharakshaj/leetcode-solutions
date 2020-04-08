package codingProblems;

public class LlHasCycle {

    private static boolean hasCycle(ListNode1 head) {
        ListNode1 fastPointer = head;
        ListNode1 slowPointer = head;

        while(fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if(fastPointer == slowPointer) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        ListNode1 temp = head.next;
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = temp;

        hasCycle(head);

    }
 }
