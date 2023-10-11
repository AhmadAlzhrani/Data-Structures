//package lab11;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 13;
		entry[] elems = new entry[size];
		for(int i = 0; i<size; i++) {
			elems[i] = new entry(0,"E");
		}
		System.out.println("** The HashTable is initialized with 0's ");
		HashTable ht = new HashTable(elems, size);
		boolean check = ht.insert(18);
		
		check = ht.insert(26);
		
		check = ht.insert(35);
		

		check = ht.insert(9);
		System.out.println("After inserting 18, 26, 35, and 09,\nhashtable is");
		ht.toString();

		int x = 15;
		int ind = ht.find(x); 
		if(ind >=0) {
			System.out.println(x+ " is found at "+ ind);
		}
		else System.out.println(x+ " not found");
		
		x = 48;
		ind = ht.find(x);
		if(ind>=0) {
			System.out.println(x+ " is found at " + ind);
		}
		else System.out.println(x+ " not found");
		
		x = 35;
		check = ht.delete(x);
		if(check)
			System.out.println(x + " successfully deleted");
		else
			System.out.println(x+" not found");
		
		x = 9;
		ind = ht.find(x);
		if(ind>=0) {
			System.out.println(x+ " is found at " + ind);
		}
		else System.out.println(x+ " not found");
		
		check = ht.insert(64);
		
		check = ht.insert(47);
		
		System.out.println("\nAfter deleting 35 and inserting 64 and 47,\nhashtable is");
		
		ht.toString();
		
		x = 35;
		ind = ht.find(x);
		if(ind>=0) {
			System.out.println(x+ " is found at " + ind);
		}
		else System.out.println(x+ " not found");
		
		
		
		
	}

}
// codes used for testing
//System.out.println("Comment18: " + check + " ind >> "+ ht.find(18));
//System.out.println("Comment26: " + check + " ind >> "+ ht.find(26));
//System.out.println("Comment35: " + check+ " ind >> "+ ht.find(35));

//System.out.println("Comment9: " + check + " ind >> "+ ht.find(9));
//System.out.println("Finding 15 " + ht.find(15) );
//System.out.println("Finding 48 " + ht.find(48) );
//System.out.println("Deleting 35 " + ht.delete(35));
//System.out.println("finding 9 " + ht.find(9));
//System.out.println("Comment64: " + check + " ind >> "+ ht.find(26));
//System.out.println("Comment47: " + check + " ind >> "+ ht.find(26));
		//System.out.println("Finding 35: "+ht.find(26));
//ht.insert(22);
		//ht.insert(35);
		//ht.insert(0);