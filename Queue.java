public class Queue {
    private Node first;
    private Node last;
    private int length;


    class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
    }

    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length=1;
    }

    public void printQueue(){
        System.out.println("Length: "+length);
        if(first!=null){
            System.out.println("First: "+first.value);
        }
        if(first!=null){
            System.out.println("Last: "+last.value);
        }
        Node temp = first;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("============");
    }

    public void enqueue(int value){
        Node temp = new Node(value);
        if(length==0){
            first = temp;
            last = temp;
        } else {
            last.next=temp;
            last=temp;
        }
        length++;
    }

    public Node dequeue(){
        if(length==0){
            return null;
        }
        Node temp = first;
        if(length==1){
            first=null;
            last=null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

}
