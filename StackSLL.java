package classses;

import java.util.EmptyStackException;

/**
 * Author: Eric Altenburg
 * Date: 10/1/18
 **/
public class StackSLL <E> implements StackInt<E> {

    public static class Node<F> {

        //data fields for Node
        private F data;
        private Node<F> next;

        public Node(F data) {
            super();
            this.data = data;
        }

        public Node(F data, Node<F> next) {
            super();
            this.data = data;
            this.next = next;
        }
    }

    //data fields
    private Node<E> top;
    private int size;

    //constructor
    StackSLL() {
        top = null;
        size = 0;
    }

    //methods
    public void push (E item) {
        top = new Node<E>(item, top);
        size++;
    }

    public E peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public E pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        E temp = top.data;
        top = top.next;
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> current = top;
        while (current != null) {
            s.append(current.data);
            if (current.next!=null) {
                s.append("->");
            }
            current = current.next;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        StackSLL<Integer> s= new StackSLL<Integer>();
        System.out.println(s.peek());
        s.push(1);

        s.push(2);
        s.push(3);

        System.out.println(s);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
    }
}
