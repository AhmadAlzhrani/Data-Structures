// Ahmad Fahad Alzhrani 201917030

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class s201917030_PartB {

	public static void main(String[] args) throws IOException {
		
		String args0 = args[0];
		String args1 = args[1];
		File input = new File(args0);
		File output = new File(args1);
		
		Scanner read = new Scanner(input);
		FileWriter write = new FileWriter(output);
		
		BST<Integer> nums = new BST<Integer>();
		
		while (read.hasNextInt()) {
			int data = read.nextInt();
			nums.insert(data);
			
			}
		
		write.write("(a) "+nums.leaf()+"   (b) "+nums.leftc()+"   (c) "+nums.rightc()+"   (d) "+nums.inorder()+"   (e) "+nums.breadth());
		read.close();
		write.close();
	}

}
class Queue<T> {
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();
    public Queue() {
    }
    public void clear() {
        list.clear();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public T firstEl() {
        return list.getFirst();
    }
    public T dequeue() {
        return list.removeFirst();
    }
    public void enqueue(T el) {
        list.addLast(el);
    }
    public String toString() {
        return list.toString();
    }
}
class BSTNode<T extends Comparable<? super T>> {
    protected T el;
    protected BSTNode<T> left, right;
    public BSTNode() {
        left = right = null;
    }
    public BSTNode(T el) {
        this(el,null,null);
    }
    public BSTNode(T el, BSTNode<T> lt, BSTNode<T> rt) {
        this.el = el; left = lt; right = rt;
    }
}
class BST<T extends Comparable<? super T>> {
	private ArrayList<T> leafs = new ArrayList<T>();
	private ArrayList<T> lcs = new ArrayList<T>();
	private ArrayList<T> rcs = new ArrayList<T>();
	private ArrayList<T> io = new ArrayList<T>();
    protected BSTNode<T> root; 
        
    public BST() {
    	root = null;
    }
    
    public BST(BSTNode<T> node) {
    	root = node;
    }

    public void clear() {
        root = null;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public void insert(T el) {
        BSTNode<T> p = root, prev = null;
        while (p != null) {  // find a place for inserting new node;
            prev = p;
            if (el.compareTo(p.el) < 0)
                 p = p.left;
            else p = p.right;
        }
        if (root == null)    // tree is empty;
             root = new BSTNode<T>(el);
        else if (el.compareTo(prev.el) < 0)
             prev.left  = new BSTNode<T>(el);
        else prev.right = new BSTNode<T>(el);
    }
    
    public boolean isInTree(T el) {
        return search(el) != null;
    }
    
    protected T search(T el) {
        BSTNode<T> p = root;
        while (p != null)
            if (el.equals(p.el))
                 return p.el;
            else if (el.compareTo(p.el) < 0)
                 p = p.left;
            else p = p.right;
        return null;
    }
    
    public void preorder() {
        preorder(root);
    }
    
    public String inorder() {
    	io.clear();
        inorder(root);
        return io.toString().substring(1, io.toString().length()-1).replaceAll(",", "");
    }
    
    protected void visit(BSTNode<T> p) {
        System.out.print(p.el + " ");
    }
    
    protected void inorder(BSTNode<T> p) {
        if (p != null) {
             inorder(p.left);
             io.add(p.el);
             inorder(p.right);
        }
    }
    
    protected void preorder(BSTNode<T> p) {
        if (p != null) {
             visit(p);
             preorder(p.left);
             preorder(p.right);
        }
    }
    
    public void deleteByCopying(T el) {
        BSTNode<T> node, p = root, prev = null;
        while (p != null && !p.el.equals(el)) {  // find the node p
             prev = p;                           // with element el;
             if (el.compareTo(p.el) < 0)
                  p = p.left;
             else p = p.right;
        }
        node = p;
        if (p != null && p.el.equals(el)) {
             if (node.right == null)             // node has no right child;
                  node = node.left;
             else if (node.left == null)         // no left child for node;
                  node = node.right;
             else {
                  BSTNode<T> tmp = node.left;    // node has both children;
                  BSTNode<T> previous = node;    // 1.
                  while (tmp.right != null) {    // 2. find the rightmost
                      previous = tmp;            //    position in the
                      tmp = tmp.right;           //    left subtree of node;
                  }
                  node.el = tmp.el;              // 3. overwrite the reference
                                                 //    to the element being deleted;
                  if (previous == node)          // if node's left child's
                      previous.left  = tmp.left; // right subtree is null;
                 else previous.right = tmp.left; // 4.
             }
             if (p == root)
                  root = node;
             else if (prev.left == p)
                  prev.left = node;
             else prev.right = node;
        }
        else if (root != null)
             System.out.println("el " + el + " is not in the tree");
        else System.out.println("the tree is empty");
    }
    public String breadth() {
    	io.clear();
    	breadthFirst();
    	return io.toString().substring(1, io.toString().length()-1).replaceAll(",", "");
    }
    
    protected void breadthFirst() {
        BSTNode<T> p = root;
        Queue<BSTNode<T>> queue = new Queue<BSTNode<T>>();
        if (p != null) {
             queue.enqueue(p);
             while (!queue.isEmpty()) {
                 p = queue.dequeue();
                 io.add(p.el);
                 if (p.left != null)
                      queue.enqueue(p.left);
                 if (p.right != null)
                      queue.enqueue(p.right);
             }
        }
    }
    
    public void balance(T data[], int first, int last) {
        if (first <= last) {
            int middle = (first + last)/2;
            insert(data[middle]);
            balance(data,first,middle-1);
            balance(data,middle+1,last);
        }
    }
    
    public void balance(T data[]) {
        balance(data,0,data.length-1);
    }
    protected void count() {
		leafs.clear();
		rcs.clear();
		lcs.clear();
		helper(root);
	}
    protected void helper(BSTNode<T> p) {
    	if (p != null) {
    		if(p.right==null & p.left ==null)
    			leafs.add(p.el);
    		if(p.right != null)
    			rcs.add(p.right.el);
    		if(p.left != null)
    			lcs.add(p.left.el);
   
    	helper(p.left);
    	helper(p.right);
    	}
    }
    public int leaf() {
    	count();
    	return leafs.size();
    }
    public int rightc() {
    	count();
    	return rcs.size();
    }
    public int leftc() {
    	count();
    	return lcs.size();
    }
    public void swap(BSTNode<T> root)
    {
        if (root == null) {
            return;
        }
 
        BSTNode<T> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
 
    public void mirror(BSTNode<T> root)
    {
        if (root == null) {
            return;
        }

        mirror(root.left);
 
        mirror(root.right);
 
        swap(root);
    }
}
