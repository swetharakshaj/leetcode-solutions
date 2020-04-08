package codingProblems;

public class AddTwoNumbersAsLinkedLists {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = null, firstNode = null, result = null;
        int sum, carry=0;

        while(l1!= null || l2 != null) {
            sum = carry + (l1 != null? l1.val : 0) + (l2 != null ? l2.val: 0);
            carry = sum >=10? 1 : 0;
            sum = sum%10;
            temp = new ListNode(sum);
            if(firstNode == null) {
                firstNode = temp;
            } else {
                result.next = temp;
            }
            result= temp;

            if(l1!=null ) { l1 = l1.next; }
            if(l2!= null) { l2 = l2.next; }
        }
        return firstNode;
    }

    public static void main (String args[] ) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(6);

        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(7);

        ListNode result = addTwoNumbers( l1, l2);
        System.out.println("***********");
       while(result != null) {
           System.out.println(result.val);
           result = result.next;
       }

    }
}


//9 9 9 4 6
//
//8 7
//

// 7 7 0 5 6


//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.
//
//
//
//l1 = 2 l2 = 5 sum = 7 carry = 0  temp = ListNode(7)        result = 7
//
//l1 = 4 l2 = 6 sum = 10 carry = 1 sum = 0 temp = ListNode(0)  result.next = 0
//
//l1 = 8 l2 = 4 sum = 1 + 12 = 13 carry = 1 temp = ListNode(3) result.next = 3


