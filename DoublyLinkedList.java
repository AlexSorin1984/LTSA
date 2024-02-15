public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void swapFirstLast(){
        if(length<2){
            return;
        }
     // 7 5 8 4 9 2
        Node front = head;
        Node back = tail;
        Node frontNext = head.next;
        Node backPrevious = tail.prev;

        head = back;
        head.next = frontNext;
        head.prev = null;
        frontNext.prev=head;

        tail = front;
        tail.prev = backPrevious;
        tail.next = null;
        backPrevious.next=tail;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = null;

        while(temp!=null){
            after = temp.next;
            temp.next = before;
            temp.prev = after;
            before = temp;
            temp = after;
        }
    }

    public void reverseBetter() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public boolean isPalindrome() {
        if(head==tail){
            return true;
        }
        Node tempHead = head;
        Node tempTail = tail;

        while(tempHead!=tempTail){
            if(tempHead.value!=tempTail.value){
                return false;
            }
            tempHead = tempHead.next;
            tempTail = tempTail.prev;
        }

        return true;
    }

    public void swapPairs(){
        if(head==null || head.next==null){
            return;
        }
        Node temp = head;
        int originalValue;

        while(temp!=null&&temp.next!=null){
            originalValue = temp.value;
            temp.value = temp.next.value;
            temp.next.value = originalValue;
            temp = temp.next.next;
        }
    }

    public void swapPairs2(){
        if(head==null || head.next==null){
            return;
        }
        Node first = head;
        Node second = head.next;
        head = second;

        Node util = null;




        while(first!=null && second!=null){ // 1 2 3 4
            second = first.next;
            util = second.next;

            second.prev = first.prev;
            second.next = first;

            first.prev = second;
            first.next = util;
            if (util != null) {
                util.prev = first;
            }
            first = util;


        }
    }
}

