package classses;

/**
 * Author: Eric Altenburg
 * Date: 10/1/18
 **/
public interface StackInt <E> {
    E peek();
    E pop();
    void push (E item);
    Boolean isEmpty();
    int size();
}
