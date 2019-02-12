package classses;

import java.lang.reflect.Array;

/**
 * Author: Eric Altenburg
 * Date: 9/17/18
 **/
public class SingleLL <E>{

    //inner class because class node is invisible to anyone outside the list. Only SingleLL can see Node.
    private static class Node<F> {

        //data fields for Node
        private F data;
        private Node <F> next;

        public Node(F data) {
            this.data = data;
        }

        public Node(F data, Node<F> next) {
            this.data = data;
            this.next = next;
        }
    }

    //data fields for SingleLL
    private Node<E> head;
    private int size = 0;

    SingleLL() {
        head = null;
        size = 0;
    }

    public void add (E item) {
        head = new Node<E>(item, head);

        size ++;
    }

    public void add(E item, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (index==0) {
            this.add(item);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index-1; i ++) {
                current = current.next;
            }
            //current points to the node at index-1
            current.next = new Node<E>(item, current.next);
            size++;
        }
    }

    public E get(int index) {
        if (index < 0 || index > size-1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node<E> current = head;

        for (int i = 0; i < index; i ++) {
            current = current.next;
        }

        return current.data;
    }

    public int getSize() {
        return this.size;
    }

    public void removeFirst() {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        head = head.next;
        size --;
    }

    public Boolean member(E item) {
        Node<E> current = head;

        while (current != null && current.data != item) {
            current = current.next;
        }

        return current!=null;
    }

    private Boolean member2(E item, Node<E> current) {
        if (current == null) {
            return false;
        } else {
            return current.data.equals(item) || member2(item, current.next);
        }
    }

    public Boolean memeber2(E item) {
        return member2(item, head);
    }

    public Node<E> add(E item, int i, Node<E> current) {
        if (i == 0) {
            return new Node<E>(item, current);
        } else {
            current.next=add(item, i-1, current.next);
            return current;
        }
    }

    public void add2(E item, int i) {
        if (i == 0) {
            head = new Node<E>(item, head);
        } else {
            head = add(item, i, head);
        }
        size++;
    }

    public boolean isSubset(SingleLL<E> list) {
        boolean holds = true;

        Node<E> hd = list.head;
        while (hd != null) {
            holds = holds && member(hd.data);
            hd = hd.next;
        }

        return holds;
    }

    public E remove(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            E temp = head.data;
            head = head.next;
            size--;
            return temp;
        }else { //index > 0
            Node<E> current = head;
            for ( int i = 0; i < index -1; i ++) {
                current = current.next;
            }
            //current points to node at index index-1
            E temp = current.next.data;
            current.next = current.next.next;
            size--;
            return temp;
        }
    }

    public void rad() { //remove adjacent
        if (head == null || head.next == null) { //if it's empty
            return;
        }

        Node<E> current = head;

        while (current!=null && current.next != null) {
            if (current.data.equals(current.next.data)) { //comparing current.next so it can't be null or nullpointerexception
                current.next = current.next.next;
                size--;
            } else {
                current = current.next;
            }
        }
    }

    private Boolean memFrom(Node<E> l, E item) {
        Node<E> current = l;
        Boolean mem = false;

        while (current != null) {
            mem = mem || current.data.equals(item);
            current = current.next;
        }
        return mem;
    }

    public Boolean hasDuplicates() {
        Node<E> current = head;
        Boolean hasDupl = false;

        while (current != null && !hasDupl) {
            hasDupl = hasDupl || memFrom(current.next, current.data);
            current = current.next;
    }

        return hasDupl;
    }

    /**
     * Indicates whether the list of l2 is included in the recipient list
     * A list l2 is included in a list l1, if every element of l2 is a memeber of l1
     * @param l2
     * @return
     */
    public Boolean included(SingleLL<E> l2) {
        return null;
    }


//    public Boolean sorted(){
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        Node<E> current = head;
//        Boolean checked = true;
//
//        while (current != null && current.next!= null) {
//            if (current.data.compareTo(current.next.data) > 0) {
//                return false;
//            }
//
//            current = current.next;
//        }
//
//        return checked;
//    }

    public void stutter() {
        if (head == null || head.next == null) {
            return;
        }

        Node<E> current = head;
        int index = 1;

        while (current != null) {
            add(current.data, index);

            index+=2;
            current = current.next.next;
            size++;
        }
    }

    public Boolean isSingleton() {
        if (head==null) {
            return false;
        }

        Boolean isSingle = this.size == 1;

        return isSingle;
    }

    //couldn't get it to work
//    public Boolean allNonNull() {
//        Boolean noNull = true;
//
//        if (head == null && this.size == 1) {
//            return false;
//        }
//
//        Node<E> current = head;
//
//        for (int i = 0; i < size && noNull; i ++) {
//            if (current == null) {
//                noNull = false;
//            }
//            current = current.next;
//        }
//
//        return noNull;
//    }

    public SingleLL<E> append(SingleLL<E> l2) {
        SingleLL<E> finalLL = new SingleLL<E>();

        Node<E> tempCurrent = this.head;
        int index = 0;

        while(tempCurrent != null) {
            finalLL.add(tempCurrent.data, index);
            tempCurrent = tempCurrent.next;
            index++;
            finalLL.size++;
        }

        tempCurrent = l2.head;

        while (tempCurrent != null) {
            finalLL.add(tempCurrent.data, index);
            tempCurrent = tempCurrent.next;
            index ++;
            finalLL.size++;
        }

        return finalLL;
    }

    public SingleLL<E> zipL(SingleLL<E> l2) {
        SingleLL<E> finalLL = new SingleLL<E>();

        Node<E> tempCurrent1 = this.head;
        Node<E> tempCurrent2 = l2.head;
        int index = 0;
        int howMuch = 0;

        if(this.size > l2.size) {
            howMuch = this.size - l2.size;
            while (tempCurrent2 != null) {
                if (index%2 == 0) {
                    finalLL.add(tempCurrent1.data, index);
                    tempCurrent1 = tempCurrent1.next;
                } else {
                    finalLL.add(tempCurrent2.data, index);
                    tempCurrent2 = tempCurrent2.next;
                }
                index ++;
                size++;
            }
            for (int i = 0; i < howMuch; i ++) {
                finalLL.add(tempCurrent1.data, index);
                tempCurrent1 = tempCurrent1.next;
                index++;
                size++;
            }
        } else if (l2.size > this.size) {
            howMuch = l2.size - this.size;
            while (tempCurrent1 != null) {
                if (index%2 == 0) {
                    finalLL.add(tempCurrent1.data, index);
                    tempCurrent1 = tempCurrent1.next;
                } else {
                    finalLL.add(tempCurrent2.data, index);
                    tempCurrent2 = tempCurrent2.next;
                }
                index ++;
                size++;
            }
            for (int i = 0; i < howMuch; i ++) {
                finalLL.add(tempCurrent2.data, index);
                tempCurrent2 = tempCurrent2.next;
                index ++;
                size++;
            }
        } else {
            while (tempCurrent1 != null || tempCurrent2 != null) {
                if (index%2 == 0) {
                    finalLL.add(tempCurrent1.data, index);
                    tempCurrent1 = tempCurrent1.next;
                } else {
                    finalLL.add(tempCurrent2.data, index);
                    tempCurrent2 = tempCurrent2.next;
                }
                index ++;
                size++;
            }
        }

        return finalLL;
    }

    public void addLast(E item) {
        if (head == null) {
            return;
        }

        Node<E> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node<E>(item, null);
        size++;
    }

    /*I did not know how to get the class to extends Pair with the SingleLL generics, but I tried my best
    to make the method work without being able to test it. For now since I can't get it to compile with
    the current aforementioned issue, the class will be commented out as if I don't, it won't compile.*/
    /*
    public SingleLL<Pair<E, Integer>> compress() {
        if (head == null || head.next == null) {
            throw new IllegalArgumentException();
        }

        if (this.isSingleton()) {
            SingleLL<Pair<E, Integer>> l = new SingleLL<Pair<E, Integer>>();
            Pair<E, Integer> temp = new Pair<E, Integer>(head.data, 1);
            l.add(temp);
            size++;
            return l;
        } else {
            Node<E> current = head;
            SingleLL<Pair<E, Integer>> l2 = new SingleLL<Pair<E, Integer>>();

            while (current != null){
                int counter = 0;
                Node<E> temp = current;
                while(current.data.equals(current.next.data))
                {
                    counter++;
                    current = current.next;
                }
                Pair<E, Integer> tempPair = new Pair<E, Integer>(temp.data, counter);
                l2.add(tempPair);

                for (int i = 0; i < counter; i ++) {
                    current = current.next;
                }
            }
            return l2;
        }
    }
    */

    public SingleLL<Pair<E, Integer>> compress() {
        SingleLL<Pair<E, Integer>> l = new SingleLL<Pair<E, Integer>>();
        if (head == null) {
            return l;
        }
        if (head.next == null) {
            l.add(new Pair<E, Integer>(head.data, 1));
            return l;
        }

        int count = 1;
        Node<E> current = head;
        while (current.next != null) {
            if (current.data.equals(current.next.data)) {
                count++;
            } else {
                l.addLast(new Pair<E, Integer>(current.data, count));
                count = 1;
            }
            current = current.next;
        }
        l.addLast(new Pair<E, Integer>(current.data, count));
        return l;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> current = head;

        while (current != null) {
            s.append(current.data.toString() + ", ");
            current = current.next;
        }

        return s.toString();
    }

    public static void main(String[] args) {
        SingleLL<Integer> l = new SingleLL<Integer>();
//        SingleLL<Integer> l2 = new SingleLL<Integer>();
//        SingleLL<Integer> l3 = new SingleLL<Integer>();
//
//        l.add(5);
//        l.add(3);
//        l.add(1);
//        l.add(66);

//        SingleLL<Pair<E, Integer>> l = new SingleLL<Pair<E, Integer>>();


//        l2.add(6);
//        l2.add(4);
//        l2.add(2);

//        System.out.println(l);
//        System.out.println(l2);
//        l3 = l.zipL(l2);
//        System.out.println(l3);

//        l.addLast(7);
//        System.out.println(l);



//        for (int i = 5; i < 10; i ++) {
//            l.add(i);
//            l.add(i);
//        }

//        System.out.println(l);
//        System.out.println(l2);
//
//        l3 = l.append(l2);
//        System.out.println(l3);

//        System.out.println(l.allNonNull());

//        System.out.println(l.hasDuplicates());

//        System.out.println(l.get(4));
//        l.removeFirst();
//        System.out.println(l);
//        System.out.println(l.member(4));
//        System.out.println(l.member(12));

//        System.out.println(l.sorted());
//
//        l.stutter();
//        System.out.println(l);

        for ( int i = 10; i > 0; i--) {
            l.add(i);
        }
        l.add(120);
        System.out.println(l.head.data);

//        l.add2(10,2);
//        l.add2()
    }
}