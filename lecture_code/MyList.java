package classses;

import java.util.Arrays;

/**
 * Author: Eric Altenburg
 * Date: 9/10/18
 **/
public class MyList <E> {
    //Data fields
    final static int INIT_CAPACITY = 5;
    private E[] data;
    int capacity;
    int size = 0;

    public MyList() {
        this.data = (E[]) new Object[INIT_CAPACITY];
        capacity = INIT_CAPACITY;
        this.size = 0;
    }

    private void resize() {
        capacity *=2;

        data = Arrays.copyOf(data, capacity);
    }

    //O(n)
    public void add(E item) {
        if (size == data.length) {
            resize();
        }
        else {
            data[size] = item;
            size++;
        }
    }

    //O(n)
    public void add(E item, int index) {
        if (index < 0 || index > size-1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size == data.length) {
            resize();
        }
        for (int i = size; i > index; i --) {
            data[i] = data[i-1];
        }

        data[index] = item;
        size ++;
    }

    //O(n)
    public void remove(int index) {
        if (index  < 0 || index > size-1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = index; i  < size-1; i ++) {
            data[i] = data[i+1];
        }

        size--;
    }

    //O(1)
    public E get (int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        else {
            return data[index];
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < size; i ++) {
            s.append(data[i].toString()); //adds string to old one without wasting memory
            s.append(", ");
        }
        s.append("]");

        return s.toString();
    }

    public static void main(String[] args) {
        MyList<Integer> l = new MyList<Integer>();

        for (int i = 0; i < 10; i ++) {
            l.add(i);
        }
        System.out.println(l);

        l.add(24, 3);
        System.out.println(l);

        l.remove(5);
        System.out.println(l);
    }
}
