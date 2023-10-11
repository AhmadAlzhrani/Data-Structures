//Ahmad Fahad Alzhrani 201917030
import java.util.Arrays;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
	    Integer[] a = { 10, 2, 8, 9, 1, 6, 3, 4, 0, 5 };
	    System.out.println("The original array is: " + Arrays.toString(a));
	    BinaryHeap bh = new BinaryHeap(a, true);
	    // builds heap bottom up: change the constructor to build it top-down
	    System.out.println("\nThe heap is: " + bh);
	    System.out.println("\nSorted Array is: " + Arrays.toString(bh.heapSort()));
	
	    int i = 0;
	    Random random = new Random();
	    String[] names = {"Sun", "Ali", "Tom", "Pat", "Bert", "Rais"};
	    Patient[] patients = new Patient[6];
	    for (String name : names) {
	       patients[i] = new Patient(name, (random.nextInt(6)));
	       i++;
	    }
	    System.out.println("\nThe original order of patients arrival is>>");
	    for (Patient patient : patients)
	       System.out.println(patient);
	
	    BinaryHeap patientHeap = new BinaryHeap(patients.length);
	    for (Patient patient : patients) {
	       patientHeap.enqueue(patient);
	    }
	
	    System.out.println("\nThe TREATMENT order of patients is>>");
	
	    for (Comparable patient : patientHeap.heapSort()) {
	       System.out.println(patient);
	   }
 }

}
