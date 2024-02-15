import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
    Node root;
    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value=value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root==null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while(true){
            if(newNode.value == temp.value){
                return false;
            }
            if(newNode.value<temp.value){
                if(temp.left==null){
                    temp.left=newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if(temp.right==null){
                    temp.right=newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){
        if(root==null){
            return false;
        }
        Node temp = root;
        while(temp!=null){
            if(value<temp.value){
                temp = temp.left;
            } else if(value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean recursiveContains(Node node, int value){
        if(node==null) return false;

        if(value<node.value){
            return recursiveContains(node.left, value);
        } else if (value>node.value) {
            return recursiveContains(node.right, value);
        } else {
            return true;
        }

    }
    public boolean recursiveContains(int value){
        return recursiveContains(root, value);
    }


    private Node recursiveInsert(Node currentNode, int value){
        if(currentNode==null) return new Node(value);

        if(value<currentNode.value){
            currentNode.left = recursiveInsert(currentNode.left, value);
        } else if (value>currentNode.value) {
            currentNode.right = recursiveInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void recursiveInsert(int value){
        if(root==null) root = new Node(value);
        recursiveInsert(root, value);
    }

    private Node recursiveDelete(Node currentNode, int value){
        if(currentNode==null) return null;

        if(value<currentNode.value){
            currentNode.left = recursiveDelete(currentNode.left, value);
        } else if (value>currentNode.value) {
            currentNode.right = recursiveDelete(currentNode.right, value);
        } else {
            if(currentNode.left==null && currentNode.right==null){
                currentNode=null;
            } else if(currentNode.left==null){
                currentNode=currentNode.right;
            } else if(currentNode.right==null){
                currentNode=currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value=subTreeMin;
                currentNode.right = recursiveDelete(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    public void recursiveDelete(int value){
        recursiveDelete(root, value);
    }

    private int minValue(Node node){
        while(node!=null){
            node=node.left;
        }

        return node.value;
    }

    public ArrayList<Integer> bfs(){
        ArrayList<Integer> list1 = new ArrayList<>();
        Queue<Node> myQueue = new LinkedList<>();

        Node currentNode=root;
        myQueue.add(currentNode);

        while(myQueue.size()>0){
            currentNode = myQueue.remove();
            list1.add(currentNode.value);
            if(currentNode.left!=null){
                myQueue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                myQueue.add(currentNode.right);
            }
        }
        return list1;
    }

    public ArrayList<Integer> dfsPreOrder(){
        ArrayList<Integer> list1 = new ArrayList<>();
        Stack<Node> myStack = new Stack<>();
        Node currentNode = root;
        myStack.push(currentNode);

        while(myStack.size()>0){
            currentNode = myStack.pop();
            list1.add(currentNode.value);

            if(currentNode.right!=null){
                myStack.add(currentNode.right);
            }
            if(currentNode.left!=null){
                myStack.add(currentNode.left);
            }
        }
        return list1;
    }

    public ArrayList<Integer> recursiveDFSPreOrder(){
        ArrayList<Integer> list1 = new ArrayList<>();

        class Traverse{
            Traverse(Node node){
                list1.add(node.value);
                if(node.left!=null){
                    new Traverse(node.left);
                }
                if(node.right!=null){
                    new Traverse(node.right);
                }
            }
        }

        new Traverse(root);
        return list1;
    }
    
    public Integer kthSmallestNode(int k){
        Node currentNode = root;
        ArrayList<Integer> list1 = new ArrayList<>();
        Stack<Node> myStack = new Stack();


        while (myStack.size()>0 || currentNode!=null){

            if(currentNode!=null){
                myStack.push(currentNode);
                currentNode=currentNode.left;
            } else {
                currentNode = myStack.pop();
                k-=1;
                if (k == 0) {
                    return currentNode.value;
                }
                currentNode=currentNode.right;
            }
        }

        return null;
    }

}
