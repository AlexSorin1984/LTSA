import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        if(length==0){
            System.out.println("List is empty");
            System.out.println("----------------------");
            return;
        }
        Node temp = head;
        System.out.println("Length: "+length);
        System.out.println("Head = "+head.value+" / Tail = "+tail.value);
        System.out.print("List elements: ");
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;

        }
        System.out.println();
        System.out.println("----------------------");
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length==0){
            System.out.println("List empty, nothing to remove");
            return null;
        }
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next=null;
        length--;
        if(length==0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(length==0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length==0){
            tail=null;
        }
        return temp;
    }

    public Node get(int index){
        if(index<0||index>=length){
            return null;
        }
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp!=null){
            temp.value=value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index<0||index>length){
            return false;
        }
        if(index==0){
            prepend(value);
            return true;
        }
        if(index==length){
            append(value);
            return true;
        }

        Node temp = get(index-1);
        Node newNode = new Node(value);
        newNode.next=temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    public Node remove(int index){
        if(index<0 || index>=length) return null;
        if(index==0) return removeFirst();
        if (index==length-1) return removeLast();

        Node prev = get(index-1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node prev = null;
        Node temp = head;
        Node after = temp.next;

        while(temp!=null){
            after = temp.next;
            temp.next = prev;
            prev = temp;
            temp = after;
        }

        tail = head;
        head = prev;
    }

    public void bubbleLL(){
        Node currentNode = head;
        int n;
        int j = length;

        while(j>=2){
            currentNode=head;
            while(currentNode.next!=null){
                if(currentNode.value>currentNode.next.value){
                    n = currentNode.value;
                    currentNode.value=currentNode.next.value;
                    currentNode.next.value=n;
                }
                currentNode=currentNode.next;
            }
            j--;
        }
    }

    public void bubbleSort2() {
        if (this.length < 2)
            return;

        Node sortedUntil = null;
        while (sortedUntil != this.head.next) {
            Node current = this.head;
            while (current.next != sortedUntil) {
                Node nextNode = current.next;
                if (current.value > nextNode.value) {
                    int temp = current.value;
                    current.value = nextNode.value;
                    nextNode.value = temp;
                }
                current = current.next;
            }
            sortedUntil = current;
        }
    }

    public void selectionSortLL(){
        if (this.length < 2)
            return;
        Node currentNode = head;

        while(currentNode!=null){
            Node nextNode = currentNode.next;
            Node minNode = currentNode;
            while(nextNode!=null){
                if(nextNode.value<minNode.value){
                    minNode=nextNode;
                }
                nextNode=nextNode.next;
            }
            if(minNode!=currentNode){
                int temp = currentNode.value;
                currentNode.value=minNode.value;
                minNode.value=temp;
            }
            currentNode=currentNode.next;
        }
    }

    public void insertionSortLL() {
        if (length < 2) {
            return; // List is already sorted
        }

        Node sortedListHead = head;
        Node unsortedListHead = head.next;
        sortedListHead.next = null;

        while (unsortedListHead != null) {
            Node current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;

            if (current.value < sortedListHead.value) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node searchPointer = sortedListHead;
                while (searchPointer.next != null && current.value > searchPointer.next.value) {
                    searchPointer = searchPointer.next;
                }
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        head = sortedListHead;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }

    public void revereseBetween(int startIndex, int endIndex){
        if(startIndex<0 || endIndex>=length){
            return;
        }
        Node temp = head;
        Node previous = null;
        Node startNode = null;
        Node beforeStart=null;
        Node afterLast = null;
        Node endNode=null;
        Node originalNext;
        int currentIndex = 0;

        while(temp!=null){ // 1 -> 2 -> 3 -> 4 -> 5
            if(currentIndex==startIndex-1){
                beforeStart=temp;
            }
            if(currentIndex==startIndex){
                startNode=temp;
            }
            if(currentIndex==endIndex){
                endNode=temp;
            }
            if(currentIndex==endIndex+1){
                afterLast=temp;
            }
            if(currentIndex>=startIndex && currentIndex<=endIndex){
                originalNext = temp.next;
                temp.next = previous;
                previous=temp;
                temp=originalNext;
            } else {
                previous = temp;
                temp = temp.next;
            }
            currentIndex++;
        }

        if(beforeStart!=null){
            beforeStart.next = endNode;
        }
        if(startIndex>=0){
            startNode.next = afterLast;
        } else {
            startNode.next = null;
        }
        if(endIndex==length-1){
            tail = startNode;
        }
        if(startIndex==0){
            head = endNode;
        }
    }

    public void reverseBetween2(int startIndex, int endIndex) { // 1 -> 2 -> 3 -> 4 -> 5
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }

    public int binaryToDecimal(){
        Node temp = head;
        int num = 0;
        int result;

        int i = length-1;

        while(temp!=null){
            if(temp.value==1){
                result=1;
                for(int j=0; j<i; j++){
                    result=result*2;
                }
                num+=result;
            }
            temp = temp.next;
            i--;
        }
        return num;
    }

    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;

        while (current != null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
                length -= 1;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }

    public void partitionList(int x){
        Node current = head;
        Node smaller = null;
        Node smallerHead = head;
        Node biggerHead = null;
        Node bigger=null;

        while(current!=null){   // 3, 2, 6, 8, 7, 1
            if(current.value<x){
                if(smaller==null){
                    smaller = current;// s=3
                    smallerHead=smaller;
                } else {
                    smaller.next=current;// s=2, s=1
                    smaller = smaller.next;
                }
            } else{
                if(bigger==null){
                    bigger = current; // b=6
                    biggerHead = bigger;
                } else {
                    bigger.next=current; // b=8, b=7
                    bigger = bigger.next;
                }
            }
            current = current.next;
        }
        if(smaller!=null){
            smaller.next=biggerHead;
        }
        if(bigger!=null){
            bigger.next=null;
        }
        if(smallerHead!=null){
            head = smallerHead;
        } else {
            head = biggerHead;
        }
    }

    public Node findKthFromEnd(int k){ // 3, 2, 6, 8, 7, 1
        Node current1 = head;
        Node current2 = head;
        int i = 0;
        while(i<k){
            if (current1 == null) {
                return null;
            }
            current1 = current1.next;
            i++;
        }

        while(current1!=null){
            current2 = current2.next;
            current1 = current1.next;
        }

        return current2;
    }

    public boolean hasLoop(){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }

        return false;
    }

    public Node findMiddleNode(){

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }




}
