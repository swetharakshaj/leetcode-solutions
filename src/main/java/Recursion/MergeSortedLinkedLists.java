package Recursion;

import java.util.List;

public class MergeSortedLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode()
        {

        }

        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1 == null)
        {
            return l2;
        }

        else if(l2 == null)
        {
            return l1;
        }

        else if(l1.val < l2.val)
        {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(5);

        ListNode newHead = merge(l1, l2);

        while(newHead != null)
        {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
