package DataStructures;

public class SingleLL {

    SingleLLNode head;

    static class SingleLLNode {
        private int data;
        private  SingleLLNode next;

         SingleLLNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private SingleLL insertAtEnd(SingleLL list, int data) {
        SingleLLNode  node = new SingleLLNode(data);

        if(list.head == null) {
            list.head = node;
        }
        else {
            SingleLLNode temp = list.head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        return list;
    }

    private void printList(SingleLL list) {
        SingleLLNode node = list.head;

        while(node != null)
        {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    private SingleLL insertAtBeginning(SingleLL list, int data) {
        SingleLLNode newHead = new SingleLLNode(data);

        if(list.head == null) {
            list.head = newHead;
        }
        else {
            SingleLLNode currHead = list.head;
            list.head = newHead;
            newHead.next = currHead;
        }
        return list;
    }
    private SingleLL deleteFirstOccurence (SingleLL list, int data) {
        if(list.head == null) {
            return list;
        }
        if(list.head.next == null && list.head.data == data) {
            return new SingleLL();
        }

        if(list.head.next == null && list.head.data != data) {
            return list;
        }

        SingleLLNode curr = list.head;
        SingleLLNode prev = list.head;
        while (curr.data != data) {
                prev = curr;
                curr = curr.next;
        }
        // link prev to curr.next
        prev.next = curr.next;
        return list;
    }

    private SingleLL deleteAllOccurences(SingleLL list, int data) {
        if(list.head == null) {
            return list;
        }
        if(list.head.next == null && list.head.data == data) {
            return new SingleLL();
        }

        if(list.head.next == null && list.head.data != data) {
            return list;
        }

        SingleLLNode head = list.head;
        if(head.data == data) {
            list.head = head.next;
        }

        SingleLLNode curr = list.head;
        SingleLLNode prev = list.head;
        while (curr != null) {
            if (curr.data == data ) {

                prev = curr;
                curr = curr.next;
                prev.next = curr.next;
                curr = prev.next;
        }
            else {
                curr = curr.next;
                prev = prev.next;
            }



        }
        return list;
    }

    private int getSize(SingleLL list) {
        int size = 0;
        if(list.head == null) return size;
        SingleLLNode curr = list.head;
        while(curr != null) {
            size++;
        }
        return size;

    }

}
