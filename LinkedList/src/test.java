
public class test {

	public static void main(String[] args) {
		SLL<String> myList = new SLL<String>();
		myList.addToHead("Apple");
		myList.addToHead("Peach");
		myList.addToHead("Lime");
		myList.addToHead("Avocado");
		myList.addToHead("Mango");
		myList.printAll();
		myList.insertBefore("Fruits","Apple");
		myList.printAll();
		/*myList.insertAfter("Watermelon","Lime" );
		myList.printAll();
		myList.deleteAfter("Mango");
		myList.printAll();
		myList.deleteBefore("Peach");
		myList.printAll();*/
		

	}

}
