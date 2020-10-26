package classses;

import java.util.ArrayList;

public class BTree<E> {
	public static class Node<F>{
		protected F data;
		protected Node<F> left;
		protected Node<F> right;
		
		
		public Node(F data) {
			super();
			this.data = data;
			left=null;
			right=null;
		}


		public Node(F data, Node<F> left, Node<F> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}


		public F getData() {
			return data;
		}


		public void setData(F data) {
			this.data = data;
		}


		public Node<F> getLeft() {
			return left;
		}


		public void setLeft(Node<F> left) {
			this.left = left;
		}


		public Node<F> getRight() {
			return right;
		}


		public void setRight(Node<F> right) {
			this.right = right;
		}

		public boolean isLeaf() {
            return left == null && right == null;
        }
		
	}
	// Data fields
	protected Node<E> root;
	protected int size;

	// Constructors
	public BTree() {
		root=null;
		size=0;
	}

	public BTree(E data) {
		size = 1;
		root = new Node<E>(data); 
	}
	
	public BTree(E data, BTree<E> leftTree, BTree<E> rightTree) {
		size = leftTree.size+rightTree.size+1;
		root = new Node<E>(data,leftTree.root,rightTree.root); 
	}

	public int size(Node<E> root) {
		if (root == null) {
			return 0;
		}

		return 1 + size(root.left) +size(root.right);
	}

	public int  max(int a, int b) {
		if (a > b) {
			return  a;
		}

		return b;
	}

	public int height (Node<E> root) {
		if(root==null) {
			return 0;
		}

		return 1+max(height(root.left), height(root.right));
	}

	public boolean isFullTree(Node<E> root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right==null) {
			return true;
		}
		if (root.left != null && root.right!=null) {
			return isFullTree(root.left) && isFullTree(root.right);
		} else {
			//root.left!=null && root.right == null, vice versa, this means only one child
			return false;
		}
	}

	public Integer maxTree(Node<Integer> root) {
		while (root.right != null) {
			root=root.right;
		}

		return root.data;
	}

	public Integer minTree(Node<Integer> root) {
		while(root.left!= null){
			root = root.left;
		}

		return root.data;
	}

	public boolean isBinarySearchTree(Node<Integer> root) {
		if (root == null || root.left==null && root.right==null) {
			return true;
		}
		if (root.left == null) {
			return root.data<minTree(root.right) && isBinarySearchTree(root.right);
		}
		if (root.right == null) {
			return root.data > maxTree(root.left) && isBinarySearchTree(root.right);
		}
		return root.data>maxTree(root.left) && root.data<minTree(root.right) && isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
	}

	public boolean isLeaf() {
        return root!= null && root.isLeaf();
    }

    public int no_of_leaves(Node<E> current) {
	    if (current == null) {
	        return 0;
        }
        if (current.isLeaf()) {
            return 1;
        } else {
            return no_of_leaves(current.left) + no_of_leaves(current.right);
        }
    }

    public int no_of_leaves() {
	    return no_of_leaves(root);
    }

    private ArrayList<E> preorder(Node<E> current) {
	    ArrayList<E> r = new ArrayList<E>();

	    if (current == null) {
	        return r;
        }

        r.add(current.data);
		r.addAll(preorder(current.left));
		r.addAll(preorder(current.right));
		return r;
    }

    public ArrayList<E> preorder() {
	    return preorder(root);
    }

	private Node<E> mirror_image(Node<E> current) {
		if (current == null) {
			return null;
		}
		Node<E> mirror_right = mirror_image(current.right);
		Node<E> mirror_left = mirror_image(current.left);
		current.left = mirror_right;
		current.right = mirror_left;
		return current;
	}

	public void mirror_image() {
		root = mirror_image(root);
	}

    private BTree<E> cloneAt(Node<E> current) {
		if (current == null) {
			return new BTree<E>();
		}
		if (current.isLeaf()) {
			return new BTree<E>(current.data);
		}
		return new BTree<E>(current.data, cloneAt(current.left), cloneAt(current.right));
	}

    private ArrayList<BTree<E>> projectLevel(int i, Node<E> current) {
		ArrayList<BTree<E>> r = new ArrayList<BTree<E>>();

		if (i == 0 && current != null) { //found the designated level
			r.add(cloneAt(current));
		} else {
			if (current != null) {
				r.addAll(projectLevel(i-1, current.left));
				r.addAll(projectLevel(i-1, current.right));
			}
		}
		return r;
	}

    public ArrayList<BTree<E>> projectLevel(int i ) {
		return projectLevel(i, root);
	}

    public ArrayList<BTree<E>> st() {
		ArrayList<BTree<E>> r = new ArrayList<BTree<E>>();

		for (int i = 0; i < height(root); i ++) {
			r.addAll(projectLevel(i));
		}

		return r;
	}

	private String toString(Node<E> current, int i) {
		StringBuilder s = new StringBuilder();
		for (int j=0; j<i; j++) {
			s.append("---");
		}

		if (current==null) {
			s.append("null");
			return s.toString();
		}
		
		s.append(current.data.toString());
		s.append("\n");
		s.append(toString(current.left,i+1));
		s.append("\n");
		s.append(toString(current.right,i+1));
		return s.toString();
	}
	
	public String toString() {
		return toString(root,0);
	}
	
	public static void main(String[] args) {
		
//		BTree<Integer> leaf2 = new BTree<Integer>(2);
//		BTree<Integer> leaf4 = new BTree<Integer>(4);
//		BTree<Integer> bt = new BTree<Integer>(3, leaf2, new BTree<Integer>(7, leaf4, new BTree<Integer>()));
//		BTree<Integer> bt2 = new BTree<Integer>();

//		System.out.println(bt);
//		System.out.println(bt.isLeaf());
//		System.out.println(bt.no_of_leaves());
//		System.out.println(bt2.no_of_leaves());

//		bt.mirror_image();
//		System.out.println(bt);
//
//		System.out.println(bt.st());
		BST<Integer> rightLeaf = new BST<Integer>(3);
		BST<Integer> leaf1 = new BST<Integer>(4);
		BST<Integer> leaf2 = new BST<Integer>(5);
		BST<Integer> bst = new BST<Integer>(1, new BST<Integer>(2, leaf1, leaf2), rightLeaf);

		System.out.println(bst);

	}
}
