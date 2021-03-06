package classses;

import java.util.ArrayList;

/**
 * Author: Eric Altenburg
 * Date: 11/2/18
 **/
public class Heap <E extends Comparable<E>>{
    //Data field
    private ArrayList<E> data;

    //Constructor
    public Heap(int size) {
        super();
        this.data = new ArrayList<E>(size);
    }

    //Methods
    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    public void add(E item) {
        data.add(item);

        int current = data.size()-1;
        int parent = (current-1)/2;

        while (parent >= 0 && data.get(current).compareTo(data.get(parent)) < 0) {
            swap(current, parent);

            current = parent;
            parent = (current-1)/2;
        }
    }

    public void remove() {
        data.set(0, data.remove(data.size()-1));
        int parent = 0;
        int leftChild;
        int rightChild;
        int minChild;

        while (true) {
            leftChild = (parent*2)+1;
            rightChild = leftChild+1;
            //determine minimum
            if (leftChild > data.size()-1) { //reached a leaf
                break;
            }
            minChild = leftChild;

            if (rightChild < data.size() && data.get(rightChild).compareTo(data.get(leftChild))<0) {
                minChild = rightChild;
            }

            //Now minChild points to the smallest of the children
            if (data.get(parent).compareTo(data.get(minChild)) < 0) {
                break;
            }

            swap(parent, minChild);
            parent = minChild;
        }
    }

    public String toString() {
        return data.toString();
    }

    public static void main(String[] args) {
        Heap<Integer> h = new Heap<Integer>(20);
        Integer[] l = {6, 18, 29, 20, 28, 39, 66, 37, 26, 76, 32, 74, 89};
        for (Integer i:l) {
            h.add(i);
        }

//        h.add(3);

        System.out.println(h);
        h.remove();
        System.out.println(h);



    }
}