package codingProblems;

public class MergeTwoSortedLists {

    static ListNode1 head;
    static ListNode1 curr;


    private static ListNode1 merge2Lists(ListNode1 l1, ListNode1 l2) {

        if(l1 == null && l2 == null)
            return l1;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        while(l1 != null) {
            if(l2 != null) {
                if(l1.val <= l2.val) {
                    buildResult(l1.val);
                    l1 = l1.next;
                }
                else  {
                    buildResult(l2.val);
                    l2= l2.next;
                }
            }
            else {
                buildResult(l1.val);
                l1 = l1.next;
            }
        }
        while (l2 != null) {

            buildResult(l2.val);
            l2= l2.next;
        }

        return head;
    }

    private static void buildResult(int val) {

        if(head == null)
        {
            head = new ListNode1(val);
            curr = head;
        }
        else {
            curr.next = new ListNode1(val);
            curr = curr.next;
        }
    }


    public static void main(String[] args) {
        ListNode1 l1 = new ListNode1(1);
        l1.next = new ListNode1(2);
        l1.next.next = new ListNode1(4);

        ListNode1 l2 = new ListNode1(1);
        l2.next = new ListNode1(3);
        l2.next.next = new ListNode1(4);

        ListNode1 resultHead = merge2Lists(l1, l2);
        printList(resultHead);

    }

    private static void printList(ListNode1 node) {
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
 class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
}
