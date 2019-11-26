package classses;

import java.util.NoSuchElementException;

/**
 * Author: Eric Altenburg
 * Date: 10/3/18
 **/
public class QueueSLL<E> {

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
    private Node<E> front;
    private Node<E> rear;
    private int size;

    //constructor
    QueueSLL() {
        front = null;
        rear = null;
        size = 0;
    }

    //methods
    public boolean offer(E item) {
        rear = new Node<E>(item, rear);
        if (front == null) { //means queue is empty
            front = rear;
        }
        size++;
        return true; //would return false if there wasn't enough memory. You would have to manually check this.
    }

    public E element() {
        if (front == null) {
            throw new NoSuchElementException();
        }

        return this.front.data;
    }

    public E remove() {
        if (front == null) {
            throw new NoSuchElementException();
        }

        if (front == rear) {
            E temp = this.front.data;
            this.front = null;
            this.rear = null;
            size--;
            return temp;
        }

//        Node<E> current = this.front;
        Node<E> rearCurrent = this.rear;

        while (rearCurrent.next!=front) {
            rearCurrent = rearCurrent.next;
        }
        E temp = front.data;
        this.front = rearCurrent;
        this.front.next = null;

        size--;

        return temp;
    }

//    public static double fact (int n) {
//        if (n==0) {
//            return 1;
//        } else {
//            return (double)n*fact(n-1);
//        }
//    }
//
//    public static double facttr (double n, double acc) {
//        if (n==0) {
//            return acc;
//        } else {
//            return facttr(n-1, n*acc);
//        }
//    }
//
//    public static double fib (double n) {
//        if (n<= 1) {
//            return 1;
//        } else {
//            return fib(n-1) + fib(n-2);
//        }
//    }
//
//    public static double ffib(double n, double current, double old) {
//        if (n<= 1) {
//            return current;
//        } else {
//            return ffib(n-1, current+old, current);
//        }
//    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> current = rear;
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
//        QueueSLL<Integer> q = new QueueSLL<>();
//
//        for (int i = 0; i <10; i++) {
//            q.offer(i);
//        }
//
//        System.out.println(q);
//
//        System.out.println(q.remove());
//        System.out.println(q);

//        System.out.println(fact(100));
//        System.out.println(facttr(100, 1));
////        System.out.println(fib(50));
//        System.out.println(ffib(50,1,1));
    }
}
