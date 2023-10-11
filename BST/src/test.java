// Ahmad Fahad Alzhrani 201917030

public class test {

	public static void main(String[] args) {
		BST<Integer> a = new BST<Integer>();
		
		a.insert(8);
		a.insert(4);
		a.insert(9);
		a.insert(2);
		a.insert(7);
		
		a.breadthFirst();
		System.out.println("");
		a.preorder();
		System.out.println("");
		a.inorder();
		System.out.println("");
		a.postorder();
		System.out.println("\n count: "+a.count());
		System.out.println("2 is leaf ? "+a.isLeaf(2));
		System.out.println("4 is leaf ? "+a.isLeaf(4));
		System.out.println("count leaves: "+a.countLeaves());
		System.out.println("height: "+a.height());
		
		
		
		

	}

}
