package assignments;

import java.util.ArrayList;

/**
 * Author: Eric Altenburg
 * Date: 10/4/18
 **/
public class IDLList <E> {

    //Node Class
    private static class Node<E> {
        //Data fields
        private E data;
        private Node<E> next;
        private Node<E> prev;

        //Constructors
        /**
         * This constructor creates a single Node holding elem with next and prev pointing to null
         * @param elem - data to be stored in the Node
         */
        public Node (E elem) {
            this.data = elem;
            this.next = null;
            this.prev = null;
        }

        /**
         * This constructor creates a Node holding elem with next pointing to the next param and prev pointing to the prev
         * param.
         * @param elem - data to be stored in the Node
         * @param prev - the Node prev wants to be pointed to
         * @param next - the Node next wants to be pointed to
         */
        public Node (E elem, Node<E> prev, Node<E> next) {
            this.data = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    //Data fields
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private ArrayList<Node<E>> indices;

    //Constructor
    /**
     * This constructor creates an empty Indexed Double Link List with head set to null, tail set to null, and size set to 0.
     * Also, sets up the ArrayList with nothing in it.
     */
    public IDLList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.indices = new ArrayList<Node<E>>();
    }

    /**
     * This method adds an elem at the position index (counting from wherever head is). Indices is also changed to account
     * for the new Node being added to the IDLL.
     * @param index - place in which you want the elem to be placed in the IDLL
     * @param elem - elem to be placed in the IDLL
     * @return - true once the method is finished executing
     */
    public boolean add (int index, E elem) {
        if (index < 0 || index > this.size-1) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            this.add(elem);
        } else {
            Node<E> current = indices.get(index);
            Node<E> currentPrev = indices.get(index-1);
            Node<E> n = new Node<E>(elem, current.prev, current);
            currentPrev.next = n;
            current.prev = n;
            size++;
            indices.add(index, n);
        }

        return true;
    }

    /**
     * This method adds elem at the head which makes it the first element of the list. Indices is changed to compensate
     * for the addition of a new element to the list.
     * @param elem - element being added to the front of the list
     * @return - true once the method is finished executing
     */
    public boolean add (E elem) {
        if (this.head == null && this.tail == null) { //list is empty
            Node<E> n = new Node<E>(elem);
            this.head = n;
            this.tail = n;

            indices.add(0, n);
        } else {
            Node<E> current = indices.get(0);
            Node<E> n = new Node<E>(elem, current.prev, current);
            current.prev = n;
            this.head = n;

            indices.add(0, n);
        }
        size++;
        return true;
    }

    /**
     * This method adds elem as the new last element of the list, which is at the tail.
     * @param elem
     * @return
     */
    public boolean append (E elem) {
        if (this.size == 0) {
            this.add(elem);
        } else {
            Node<E> current = this.tail;
            Node<E> n = new Node<E>(elem, current, current.next);
            current.next = n;
            this.tail = n;
            indices.add(n);
            size ++;
        }

        return true;
    }

    /**
     * This method returns the object at position index from the head. It uses the index for fast access.
     * @param index - place where object is located
     * @return - object being located
     */
    public E get (int index) {
        if (index < 0 || index > this.size-1) {
            throw new IllegalArgumentException();
        }

        return indices.get(index).data;
    }

    /**
     * This method returns the object at the head.
     * @return - object at the head of list
     */
    public E getHead () {
        if (this.head == null && this.tail == null) {
            throw new IllegalArgumentException();
        }

        return this.head.data;
    }

    /**
     * This method returns the object at the tail;
     * @return - object at tail of list
     */
    public E getLast () {
        if (this.head == null && this.tail == null) {
            throw new IllegalArgumentException();
        }

        return this.tail.data;
    }

    /**
     * This method is a getter for the size of the list.
     * @return - the size of the list
     */
    public int size () {
        return this.size;
    }

    /**
     * This method removes and returns the object at the head. Updates the Index.
     * @return - object at head being removed
     */
    public E remove () {
        if (this.head == null && this.tail == null) {
            throw new IllegalArgumentException();
        }

        if (this.head == this.tail) {
            E temp = this.head.data;
            this.head = null;
            this.tail = null;
            indices.remove(0);
            size--;
            return temp;
        }

        Node<E> current = this.head;
        this.head = this.head.next;
        this.head.prev = null;

        size--;
        indices.remove(0);

        return current.data;
    }

    /**
     * This method removes and returns the element at the tail. Updates the index.
     * @return - object at tail being removed.
     */
    public E removeLast () {
        if (this.head == null && this.tail == null) {
            throw new IllegalArgumentException();
        }

        if (this.head == this.tail) {
            return remove();
        }

        Node<E> current = this.tail;
        Node<E> currentPrev = current.prev;

        currentPrev.next = null;
        this.tail = currentPrev;

        indices.remove(size-1); //BECAUSE THE SIZE WAS DEGRADED BEFORE THE REMOVAL that's why it didn't work before, changed to degrade after
        size--;

        return current.data;
    }

    /**
     * This method removes and returns the the element at the index provided. Updates the index.
     * @param index - place in list where the element is being removed
     * @return - element being removed
     */
    public E removeAt (int index) {
        if (index < 0 || index > this.size-1) {
            throw new IllegalArgumentException();
        }

        if (this.head == null && this.tail == null) {
            throw new IllegalArgumentException();
        }

        if (this.head == this.tail) {
            return remove();
        }

        if (index == 0) {
            return remove();
        }

        if (index == size-1) {
            return removeLast();
        }

        Node<E> temp = indices.get(index);
        Node<E> tempPrev = temp.prev;
        Node<E> tempNext = temp.next;
        tempPrev.next = temp.next;
        tempNext.prev = temp.prev;

        size--;
        indices.remove(index);
        return temp.data;
    }

    /**
     * This method removes the first occurrence of elem in the list and returns true. I t
     * @param elem - element to be removed
     * @return - true if elem was found, false if not.
     */
    public boolean remove (E elem) {
        if (this.head == null && this.tail == null) {
            throw new IllegalArgumentException();
        }

        if (this.head == this.tail) {
            if (this.head.data == elem) {
                E temp = remove();
                return true;
            } else {
                return false;
            }
        }

        Node<E> current = this.head;
        int index = 0;

        while (current != null && current.data != elem) {
            current = current.next;
            index++;
        }

        if (index == this.size) {
            return false;
        } else {
            removeAt(index);
            return true;
        }
    }

    /**
     * Presents a string representation of the list.
     * @return - string
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> current = this.head;

        s.append("null");
        while (current != this.tail.next) {
            s.append("<-");
            s.append(current.data);
            s.append("->");
            current = current.next;
        }
        s.append("null");

        return s.toString();
    }

    /* FOR TESTING PURPOSES AT TIME OF WRITING CODE. FORMAL TESTING ON IDLListTest.java.
    public static void main(String[] args) {
        IDLList<Integer> x = new IDLList<Integer>();

        System.out.println(x.add(3));
        System.out.println(x.head);
        System.out.println(x.tail);
        System.out.println(x.size);

        System.out.println(x.add(1));
        System.out.println(x.head);
        System.out.println(x.tail);
        System.out.println(x.size);

        System.out.println();
        System.out.println(x);
        System.out.println();

        System.out.println(x.add(1, 2));
        System.out.println(x.head);
        System.out.println(x.tail);
        System.out.println(x.size);

        System.out.println();
        System.out.println(x);
        System.out.println();

        System.out.println(x.append(4));
        System.out.println(x.head);
        System.out.println(x.tail);
        System.out.println(x.size);

        System.out.println();
        System.out.println(x);
        System.out.println();

        System.out.println(x.get(0));

        System.out.println();
        System.out.println(x.getHead());
        System.out.println(x.getLast());

        System.out.println();
        System.out.println(x.size());

        System.out.println();
        System.out.println(x.remove());
        System.out.println(x);
        System.out.println(x.size());

        System.out.println();
        System.out.println(x.add(1));
        System.out.println(x);
        System.out.println(x.size());

        System.out.println();
        System.out.println(x.removeLast());
        System.out.println(x);
        System.out.println(x.size());

        System.out.println();
        System.out.println(x.append(4));
        System.out.println(x);
        System.out.println(x.size());


        System.out.println();
        System.out.println(x.removeAt(2));
        System.out.println(x);
        System.out.println(x.size());

        System.out.println();
        System.out.println(x.add(2, 3));
        System.out.println(x);
        System.out.println(x.size());

        System.out.println();
        System.out.println(x.remove(1));
        System.out.println(x);
        System.out.println(x.size());

        System.out.println();
        System.out.println(x.add(1));
        System.out.println(x);
        System.out.println(x.size());

        System.out.println();
        System.out.println(x.remove(5));
        System.out.println(x);
        System.out.println(x.size());
    }
    */
}
