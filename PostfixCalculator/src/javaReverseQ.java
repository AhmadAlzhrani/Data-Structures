import java.util.Arrays;
import java.util.List;

public class javaReverseQ {
	String str;
	public javaReverseQ(String str) {
		this.str = str;
	}
	public void reverse() {
		List<String> items = Arrays.asList(str.split(" "));
		LabQueue<String> queue = new LabQueue<String>();
		for(int i =0 ; i< items.size();i++)
			queue.enqueue(items.get(i));
		System.out.println("current stack: "+queue.toString());
		LabQueue<String> newQueue = new LabQueue<String>();
		for(int i=0; i<items.size();i++)
			newQueue.enqueue(items.get(items.size()-i-1));
		System.out.println("stack after reverse: "+newQueue.toString());
	}
}
