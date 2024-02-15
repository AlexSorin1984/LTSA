public class Stack {
    private Node top;
    private int height;

    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack(){
        Node temp = top;
        System.out.println("Height: "+height);
        if(top!=null){
            System.out.println("Top: "+top.value);
        }
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("--------------");
    }

    public void push(int value){
        Node newNode = new Node(value);
        newNode.next=top;
        top=newNode;
        height++;
    }

    public Node pop(){
        if(height==0){
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next=null;
        height--;

        return temp;
    }


}
