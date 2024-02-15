public class dd<T> {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public dd(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
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
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void revereseBetween(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= length) {
            return;
        }
        Node temp = head;
        Node previous = null;
        Node startNode = null;
        Node beforeStart = null;
        Node afterLast = null;
        Node endNode = null;
        Node originalNext;
        int currentIndex = 0;

        while (temp != null) { // 1 -> 2 -> 3 -> 4 -> 5
            if (currentIndex == startIndex - 1) {
                beforeStart = temp;
            }
            if (currentIndex == startIndex) {
                startNode = temp;
            }
            if (currentIndex == endIndex) {
                endNode = temp;
            }
            if (currentIndex == endIndex + 1) {
                afterLast = temp;
            }
            if (currentIndex >= startIndex && currentIndex <= endIndex) {
                originalNext = temp.next;
                temp.next = previous;
                previous = temp;
                temp = originalNext;
            } else {
                previous = temp;
                temp = temp.next;
            }
            currentIndex++;
        }

        if (beforeStart != null) {
            beforeStart.next = endNode;
        }
        if (startIndex >= 0) {
            startNode.next = afterLast;
        } else {
            startNode.next = null;
        }
        if (startIndex == 0) {
            head = endNode;
        }
    }


}
