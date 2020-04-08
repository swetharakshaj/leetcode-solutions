package LinkedList;

import java.util.List;

public class IsPalindrome {

    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    static boolean isListPalindrome(ListNode<Integer> l) {
        if (l == null) return false;
        if (l.next == null) return true;

        ListNode<Integer> slow = l;
        ListNode<Integer> fast = l;

        ListNode<Integer> endOfFirstHalf = findMidPoint(slow, fast);
        ListNode<Integer> secondHalfHead = reverseList(endOfFirstHalf.next);

        boolean result = isPalindrome(l, secondHalfHead);

        reverseList(secondHalfHead);

        return result;

    }

   static ListNode<Integer> findMidPoint(ListNode<Integer> slow, ListNode<Integer> fast) {
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static ListNode<Integer> reverseList(ListNode<Integer> head) {
        if (head == null) return head;
        ListNode<Integer> prev = null;
        ListNode<Integer> curr = head;

        while (curr != null) {
            ListNode<Integer> newTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newTemp;
        }
        return prev;
    }

    static boolean isPalindrome(ListNode<Integer> p1, ListNode<Integer> p2) {
        while (p2 != null) {
            if (p1.value - p2.value != 0) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode<Integer> node = new ListNode<Integer>(1);
        node.next = new ListNode<Integer>(1000000000);

        node.next.next = new ListNode<Integer>(-1000000000);
        node.next.next.next = new ListNode<Integer>(-1000000000);
        node.next.next.next.next = new ListNode<Integer>(1000000000);
        node.next.next.next.next.next = new ListNode<Integer>(1);

        System.out.println(isListPalindrome(node));
    }

}
