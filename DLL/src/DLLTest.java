public class DLLTest {
	public static void main(String[] args) {
		DLL<String> test = new DLL<String>();
		for(int i = 0; i < 5; i++)
			test.addToTail("b" + i);
		
		
		DLL<String> test2 = new DLL<String>();
		for(int i = 0; i < 10; i++)
			test2.addToTail("a" + i);
		
		/*test.printReverse();
		test.insertAlternate(test2);*/
		//test.printAll();
		test2.printAll();
		test2.delete7();
		test2.printAll();
		
		
	}
}