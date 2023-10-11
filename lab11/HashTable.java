//package lab11;

public class HashTable<T> {

	private entry[] e;
	private int size;
	
	public HashTable(entry[] e, int size ) {
		this.e = e;
		this.size = size;	
	}
	
	public boolean insert(T dataObject) {
		//System.out.println("length >> " +e.length);
		
		entry new_elem = new entry(dataObject);
		int index = (new_elem.gethashcode()%size)%size;
//		System.out.println("Check elem>> "+ e[index]);
		//System.out.println("index>> "+ index);
		if (e[index].getStatus().equals("E") || e[index].getStatus().equals("D")) {
			e[index] = new entry(dataObject, "O");
			return true;
		}	else {
			//System.out.println("Collision");
			index = findNextAvailableSlot(index);
			if(index != -1) {
				e[index] = new entry(dataObject, "O");
				return true;
			} 
			
			return false;
		}	
	}
	
	public int findNextAvailableSlot(int currentslot) {
		for(int i = 0; i<e.length;i++) {
			currentslot += 1;
			if(!e[currentslot].getStatus().equals("O")) {
				return currentslot;
			}
		}
		
		return -1;
	}
	
	public boolean delete(T dataObject) {
		for(int i = 0; i<e.length; i++) {
			if(e[i].getDataObject().equals(dataObject)) {
				e[i].setStatus("D");
				return true;
				}
			}
		
		return false;
	}
	public int find(T dataObject) {
		for(int i = 0; i<e.length; i++) {
			//System.out.println("index>> " + i);
		if(e[i].getDataObject().equals(dataObject) && !e[i].getStatus().equals("D") && !e[i].getStatus().equals("E"))
			return i;
		}
		
		return -1;
	}
	
	@Override
	public String toString() {
		
		
		for(int i = 0; i<size; i++) {
			System.out.println(i+": [" + e[i].getDataObject()+", \'" +e[i].getStatus()+ "\']");
			
		}
		System.out.println();
		return "";
		
	}
	
} 
