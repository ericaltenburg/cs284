package assignments;

import java.util.Random;
import java.util.Stack;

/**
 * Author: Eric Altenburg
 * Date: 10/31/18
 **/
public class Treap<E extends Comparable<E>>{
    /**
     * Private inner class Node that will be used for referencing
     * @param <E> - generics
     */
    private static class Node<E> {

        //Data fields
        public E data; // Key for the search
        public int priority; // Random heap priority
        public Node<E> left;
        public Node<E> right;

        //Constructors
        /**
         * Creates a new Node with data and priority set to parameters along with
         * left and right children initially set to null. Checks to see if data is null
         * @param data must not be null
         * @param priority random priority assigned to Node by constructor call
         */
        public Node(E data, int priority) {
            if (data == null) { // For when data is null
                throw new IllegalArgumentException("Data cannot be null");
            }

            this.data = data;
            this.priority = priority;
            this.left = null;
            this.right = null;
        }

        //Methods
        /**
         * Performs a right rotation
         * @return reference to the new root
         */
        public Node<E> rotateRight() {
            Node<E> current = this;
            current = current.left;
            this.left = current.right;
            current.right = this;
            return current;
        }

        /**
         * Performs a left rotation
         * @return reference to the new root
         */
        public Node<E> rotateLeft() {
            Node<E> current = this;
            current = current.right;
            this.right = current.left;
            current.left = this;
            return current;
        }

        @Override
        public String toString() {
            return "(key=" +data+", priority=" +priority+ ")";
        }
    }

    //Data fields
    private Random priorityGenerator;
    private Node<E> root;

    //Constructors
    /**
     * Initializes a new empty Treap
     */
    public Treap() {
        root = null;
        priorityGenerator = new Random();
    }

    /**
     * Initializes a new empty Treap but now with the priorityGenerator
     * being from the parameter
     * @param seed
     */
    public Treap(long seed) {
        root = null;
        priorityGenerator = new Random(seed);
    }

    //Methods
    /**
     * Helper method for the add method with two parameters. Changes tree to comply
     * with heap characteristics.
     *
     * If left child, then rotate right, if right child, then rotate left.
     *
     * @param current Node being inspected
     * @param s stack containing all Nodes down path of Node insertion
     */
    private void reheap(Node<E> current, Stack<Node<E>> s) {
        if (s.empty()) {
            root = current;
            return;
        } else if (current.priority < s.peek().priority) { //No need for reheaping
            return;
        } else {
            Node<E> nodePopped = s.pop();

            if (nodePopped.left != null && nodePopped.left.equals(current)) {
                nodePopped.rotateRight();
            } else {
                nodePopped.rotateLeft();
            }

            if (!s.empty()) {
                if (s.peek().left != null && s.peek().left.equals(nodePopped)) {
                    s.peek().left = current;
                } else {
                    s.peek().right = current;
                }
            }

            reheap(current, s);
        }
    }

    /**
     * Another add function that generates a random priority then calls
     * on the other one.
     * @param key item being inserted
     * @return true if done correctly, false if key is already there
     */
    public boolean add(E key) {
        int randomInt = priorityGenerator.nextInt();
        return add(key, randomInt);
    }

    /**
     * Main add method that uses reheap for help. Adds Node to the treap.
     * @param key item being inserted
     * @param priority true if done correctly, false if key is already there
     * @return
     */
    public boolean add(E key, int priority) {
        if (root == null ) {
            root = new Node<E>(key, priority);
            return true;
        }

        Node<E> current = root;
        boolean inserted = false;
        Stack<Node<E>> s = new Stack<Node<E>>();

        while (inserted == false) {
            if (key.compareTo(current.data) == 0) {
                break;
            }

            if (key.compareTo(current.data) < 0) {
                s.push(current);
                if (current.left == null) {
                    current.left = new Node<E>(key, priority);
                    current = current.left;
                    inserted = true;
                } else {
                    current = current.left;
                }
            } else {
                s.push(current);
                if (current.right == null) {
                    current.right = new Node<E>(key,priority);
                    current = current.right;
                    inserted = true;
                } else {
                    current = current.right;
                }
            }
        }

        reheap(current, s);
        return inserted;
    }

    /**
     * Helper function for delete where most of the work is done. Finds node then makes it a leaf through one or more
     * rotations then deletes it.
     * @param key item being deleted
     * @param current current node being inspected
     * @param s stack holding all nodes visited
     * @return true if deleted, false if otherwise
     */
    private boolean delete(E key, Node<E> current, Stack<Node<E>> s) {
        boolean deleted = false;

        int comp = key.compareTo(current.data);
        if (comp < 0) { //it is in the left subtree
            s.push(current);
            return delete(key, current.left, s);
        }
        if (comp > 0 ) { //it is in the right subtree
            s.push(current);
            return delete(key, current.right, s);
        }
        if (comp == 0) { //the node has been found
            while (true) {
                if (current.left == null && current.right == null) {
                    break;
                }
                if (current.left != null && current.right != null) {
                    if (current.left.priority > current.right.priority) {
                        Node<E> grandParent = s.pop();
                        if (grandParent.right.equals(current)) {
                            grandParent.right = current.rotateRight();
                            s.push(grandParent.right); //this is the new parent
                        } else {
                            grandParent.left = current.rotateRight();
                            s.push(grandParent.left); //this is the new parent
                        }
                    } else {
                        Node<E> grandParent = s.pop();
                        if (grandParent.right.equals(current)) {
                            grandParent.right = current.rotateLeft();
                            s.push(grandParent.right);
                        } else {
                            grandParent.left = current.rotateLeft();
                            s.push(grandParent.left);
                        }
                    }
                }
                if (current.left != null && current.right == null) {
                    Node<E> grandParent = s.pop();
                    if (grandParent.right != null && grandParent.right.equals(current)) {
                        grandParent.right = current.rotateRight();
                        s.push(grandParent.right); //this is the new parent
                    } else {
                        grandParent.left = current.rotateRight();
                        s.push(grandParent.left); //this is the new parent
                    }
                }
                if (current.right != null && current.left == null) {
                    Node<E> grandParent = s.pop();
                    if (grandParent.right != null && grandParent.right.equals(current)) {
                        grandParent.right = current.rotateLeft();
                        s.push(grandParent.right);
                    } else {
                        grandParent.left = current.rotateLeft();
                        s.push(grandParent.left);
                    }
                }
            }
            Node<E> parent = s.peek();
            if (parent.left != null && parent.left.equals(current)) {
                parent.left = null;
                deleted = true;
                return deleted;
            } else {
                parent.right = null;
                deleted = true;
                return deleted;
            }
        }
        return true; //to make the method not not compile as it will hit the base cases
    }

    /**
     * Deletes specified Node with matching Key. Checks to see if empty, if there is only one node in the treap,
     * and if the key entered belongs to the root. In the case of it being the root, it performs a rotation so that the
     * key entered is no longer the root, and is instead, a child of the root.
     * @param key
     * @return true if removed, false if not found in the treap
     */
    public boolean delete(E key) {
        if (!find(key)) { //if the object isn't in the tree
            return false;
        }
        if (root.left == null && root.right == null) { //if root is the only one in tree
            root = null;
            return true;
        }
        if (root.data.equals(key)){
            if (root.left != null && root.right != null) {
                if (root.left.priority > root.right.priority) {
                    root.rotateRight();
                } else {
                    root.rotateLeft();
                }
            }
            if (root.left != null && root.right == null) {
                root = root.rotateRight();
            }
            if (root.right != null && root.left == null) {
                root = root.rotateLeft();
            }
        }
        //the object is in the tree
        Stack<Node<E>> s = new Stack<Node<E>>();
        return delete(key, root, s);
    }

    /**
     * Helper method for the find(E key) method
     * @param root Node being looked at
     * @param key item being looked for
     * @return True if found, false if not
     */
    private boolean find(Node<E> root, E key) {
        if (root == null) {
            return false;
        }

        int comp = root.data.compareTo(key);

        if (comp == 0) {
            return true;
        }
        if (comp < 0) {
            return find(root.right, key);
        } else {
            return find(root.left, key);
        }
    }

    /**
     * Finds the parameter in the Treap
     * @param key item being looked for
     * @return true if found, false if not
     */
    public boolean find(E key) {
        return find(root, key);
    }

    /**
     * Helper function for toString() that traverses the treap via preorder
     * @param current
     * @param i
     * @return string
     */
    private String toString(Node<E> current, int i) {
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < i; j++) {
            s.append("\t");
        }

        if (current == null) {
            s.append("null");
            return s.toString();
        }

        s.append(current.toString());
        s.append("\n");
        s.append(toString(current.left, i+1));
        s.append("\n");
        s.append(toString(current.right, i+1));
        return s.toString();
    }

    @Override
    public String toString(){
        return toString(root, 0);
    }
}