package classses;

/**
 * Author: Eric Altenburg
 * Date: 10/22/18
 **/
public class BST<E extends Comparable<E>> extends BTree<E>{
    //Data fields inherited from BTree
    private boolean addOk;
    private boolean deleteOk;
    private E deletedItem;

    //Constructor
    BST() {
        super();
    }

    BST(E data) {
        super(data);
    }

    BST(E data, BST<E> left, BST<E> right) {
        super(data, left, right);
    }

    //Methods
    private Boolean find(E item, Node<E> current) {
        if (current == null) {
            return false;
        }

        int comp = current.data.compareTo(item);

        //This is a more compact version of the if statements below
        return (comp == 0) || (comp < 1) ? find(item, current.right): find(item, current.left);

//        if (comp == 0) {
//            return true;
//        }
//        if (comp < 1) {
//            return find(item, current.right);
//        } else {
//            return find(item, current.left);
//        }
    }

    public Boolean find(E item) {
        return find(item, root);
    }

    private Node<E> add(E item, Node<E> current) {
        if (current == null) {
            addOk = true;
            return new Node<E>(item);
        }
        int comp = current.data.compareTo(item);
        if (comp == 0) {
            addOk = false;
            return current;
        }
        if (comp < 1) {
            current.right = add(item, current.right);
            return current;
        } else {
            current.left = add(item, current.left);
            return current;
        }
    }

    public Boolean add(E item) {
        root = add(item, root);
        return addOk;
    }

    private E minimum(Node<E> current) {
        if (current.left == null && current.right == null) {
            return current.data;
        } else {
            return minimum(current.left);
        }
    }

    public E minimum() {
        if (root==null) {
            return null;
        } else {
            return minimum(root);
        }
    }

    private E find_and_remove_max(Node<E> current) {
        E result;
        if (current.right.right == null) {
            result = current.right.data;
            E temp = current.right.data;
            current.right = current.right.left;
            return result;
        } else {
            return find_and_remove_max(current.right);
        }
    }

    private Node<E> remove(E key, Node<E> current) {
        if (current == null) { //item not found
            return null;
        }
        int comp = key.compareTo(current.data);
        if(comp < 0) { //key is in left subtree of current
            current.left = remove(key, current.left);
            return current;
        }
        if (comp > 0) { //key is in right subtree of current
            current.right = remove(key, current.right);
            return current;
        }
        if (comp == 0) { //found item to remove
            deletedItem = current.data;
            if (current.isLeaf()) { //no children
                return null;
            }
            if (current.right==null) { //left child
                return current.left;
            }
            if (current.left == null) { //right child
                return current.right;
            }
            if (current.left.right == null) {
                current.data = current.left.data;
                current.left = current.left.left;
                return current;
            }
            current.data=find_and_remove_max(current.left);
            return current;
        }
        return null;
    }

    public E remove(E key) {
        root = remove(key, root);
        return deletedItem;
    }

    /*
    left(Node<E> root) {
    Node<E> current = root;
    current = current.right;
    root.right = current.left;
    current.left = root;
    return current;
    }

    public Node<E> rightRotation(Node<E> root) {
    node<E> current = root.left;
    current = current.left;
    root.left = current.right;
    current.right = root;
    return current;
    }
     */

    public static void main(String[] args) {
//        BST<Integer> leaf2 = new BST<Integer>(12);
//        BST<Integer> leaf4 = new BST<Integer>(33);
//        BST<Integer> bst = new BST<Integer>(23, leaf2, new BST<Integer>(44, leaf4, new BST<Integer>()));
//
//        System.out.println(bst);
//        System.out.println(bst.find(100));
//        System.out.println(bst.find(12));
//        System.out.println(bst.find(33));
//        bst.add(37);
//        System.out.println(bst);
//        System.out.println(bst.minimum());
//
//        bst.remove(44);
//        System.out.println(bst);

        BST<Integer> rightLeaf = new BST<Integer>(3);
        BST<Integer> leaf1 = new BST<Integer>(4);
        BST<Integer> leaf2 = new BST<Integer>(5);
        BST<Integer> bst = new BST<Integer>(1, new BST<Integer>(2, leaf1, leaf2), rightLeaf);
        System.out.println(bst.isBinarySearchTree(bst.root));
    }
}