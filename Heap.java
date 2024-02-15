import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap(){
        heap = new ArrayList<>();
    }

    public ArrayList<Integer> getHeap(){
        return new ArrayList<>(heap);
    }

    public int leftChild(int index){
        return index*2+1;
    }

    public int rightChild(int index){
        return index*2+2;
    }

    public int parent(int index){
        return (index-1)/2;
    }

    public void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){
        heap.add(value);
        int currentIndex = heap.size()-1;

        while(currentIndex>0 && heap.get(currentIndex)>heap.get(parent(currentIndex))){
            swap(currentIndex, parent(currentIndex));
            currentIndex=parent(currentIndex);
        }
    }

    public Integer remove(){
        if(heap.size()==0){
            return null;
        }
        if(heap.size()==1){
            return heap.remove(0);
        }
        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));

        sinkDown(0);

        return maxValue;
    }

    public void sinkDown(int index){
        int maxindex = index;
        while(true){
            if(leftChild(index)<heap.size() && heap.get(leftChild(index))>heap.get(maxindex)){
                maxindex=leftChild(index);
            }
            if (rightChild(index)<heap.size() && heap.get(rightChild(index))>heap.get(maxindex)) {
                maxindex=rightChild(index);
            }
            if(maxindex==index){
                return;
            }
            swap(index, maxindex);
            index=maxindex;
        }
    }
}
