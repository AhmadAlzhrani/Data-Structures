package ass2;
import java.util.*;
import java.io.*;

public class s201917030_Q1 {

	public static void main (String[] args) throws IOException {
		String args0 = args[0];
		String args1 = args[1];
		File input = new File(args0);
		File output = new File(args1);
		
		Scanner read = new Scanner(input);
		SLL<Integer> nums = new SLL<Integer>();
		
		FileWriter write = new FileWriter(output);
		
		while (read.hasNextInt()) {
			int data = read.nextInt();
			nums.addToTail(data);
			}
		nums.printAll();
		//int len = nums.tail.info;
		nums.deleteFromTail();
		nums.printAll();
		while(read.hasNextLine()) {
			String data = read.next();
			if(data.equals("ia")) {
				int num1 = read.nextInt();
				int num2 = read.nextInt();
				if(!nums.isInList(num2))
					write.write(-1 + System.lineSeparator());
				else{
					nums.insertAfter(num1, num2);
					write.write(nums.printStr() + System.lineSeparator());
				}
			}
			else if (data.equals("ib")){
				int num1 = read.nextInt();
				int num2 = read.nextInt();
				if(!nums.isInList(num2)) {
					write.write(-1+ System.lineSeparator());
				}
				else{
					nums.insertBefore(num1, num2);
					write.write(nums.printStr()+ System.lineSeparator());
				}
			}
			else {
				int num1 = read.nextInt();
				if(!nums.isInList(num1))
					write.write(-1 + System.lineSeparator());
				else{
					nums.deleteBefore(num1);
					write.write(nums.printStr() + System.lineSeparator());
				}
			}
		}
		read.close();
		write.close();

	}

}
//************************  SLLNode.java  *******************************
//node in a generic singly linked list class 

class SLLNode<T> {
public T info;
public SLLNode<T> next;
public SLLNode() {
this(null,null);
}
public SLLNode(T el) {
this(el,null);
}
public SLLNode(T el, SLLNode<T> ptr) {
info = el; next = ptr;
}
}

//**************************  SLL.java  *********************************
//a generic singly linked list class 

class SLL<T> {
protected SLLNode<T> head, tail;
public SLL() {
head = tail = null;
}
public boolean isEmpty() {
return head == null;
}
public void addToHead(T el) {
head = new SLLNode<T>(el,head);
if (tail == null)
tail = head;
}
public void addToTail(T el) {
if (!isEmpty()) {
tail.next = new SLLNode<T>(el);
tail = tail.next;
}
else head = tail = new SLLNode<T>(el);
}
public T deleteFromHead() { // delete the head and return its info; 
if (isEmpty()) 
return null;
T el = head.info;
if (head == tail)       // if only one node on the list;
head = tail = null;
else head = head.next;
return el;
}
public T deleteFromTail() { // delete the tail and return its info;
if (isEmpty()) 
return null;
T el = tail.info;
if (head == tail)       // if only one node in the list;
head = tail = null;
else {                  // if more than one node in the list,
SLLNode<T> tmp;    // find the predecessor of tail;
for (tmp = head; tmp.next != tail; tmp = tmp.next);
tail = tmp;        // the predecessor of tail becomes tail;
tail.next = null;
}
return el;
}
public void delete(T el) {  // delete the node with an element el;
if (!isEmpty())
if (head == tail && el.equals(head.info)) // if only one
    head = tail = null;       // node on the list;
else if (el.equals(head.info)) // if more than one node on the list;
    head = head.next;    // and el is in the head node;
else {                    // if more than one node in the list
    SLLNode<T> pred, tmp;// and el is in a nonhead node;
    for (pred = head, tmp = head.next;  
         tmp != null && !tmp.info.equals(el); 
         pred = pred.next, tmp = tmp.next);
    if (tmp != null) {   // if el was found;
        pred.next = tmp.next;
        if (tmp == tail) // if el is in the last node;
           tail = pred;
    }
}
}
public String printStr() {
	String str = "";
    for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
        str += tmp.info + " ";   
return str;           
}
public void printAll() {
for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
	System.out.print(tmp.info + " ");   
System.out.println();             
}
public boolean isInList(T el) {
SLLNode<T> tmp;
for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
return tmp != null;
}
public int rec(SLLNode<T> x) {

if (x.next == null)
return 1;
else {
return 1+rec(x.next);
}
}
public int length() {
//SLLNode<T> tmp;
//int num =0;
//for ( tmp = head; tmp != null && ; tmp = tmp.next)                 // this is the normal way but i did it in recursion
//num++'
//return num;
if(isEmpty())
return 0;
else {
SLLNode<T> x = head;
int num = this.rec(x);
return num; 
}
}
public void insertBefore(T newElem, T existingElem) {
if(!isInList(existingElem))
System.out.printf("WARNING: Element %s does not exist in the linked list. Insertion failed. \n",(existingElem));
else if(existingElem.equals(head.info))
this.addToHead(newElem);
else {
SLLNode<T> tmp;
for ( tmp = head; tmp != null && tmp.next != null && !tmp.next.info.equals(existingElem); tmp = tmp.next);
SLLNode<T> ss = new SLLNode<T>(newElem,tmp.next);
tmp.next = ss;
}
}
public void insertAfter(T newElem, T existingElem) {
if(!isInList(existingElem))
System.out.printf("WARNING: Element %s does not exist in the linked list. Insertion failed. \n",(existingElem));
else if(existingElem.equals(tail.info))
this.addToTail(newElem);
else {
SLLNode<T> tmp;
for ( tmp = head; tmp != null && !tmp.info.equals(existingElem); tmp = tmp.next);
SLLNode<T> ss = new SLLNode<T>(newElem,tmp.next);
tmp.next = ss;

}

}
public void deleteBefore(T existingElem) {
if(!isInList(existingElem))
System.out.printf("WARNING: Element %s does not exist in the linked list. Insertion failed. \n",(existingElem));
else if (!isEmpty())
if (head == tail && existingElem.equals(head.info)) // if only one
	System.out.println("just 1 element in the list ");       // node on the list;
else if (existingElem.equals(head.info)) // if more than one node on the list;
	System.out.println("the existing element is the head of the list");    // and el is in the head node;
else if(existingElem.equals(head.next.info)) {
	head = head.next;
	}
else {                   
    SLLNode<T> pred, tmp;
    for (pred = head, tmp = head.next; tmp != null && /*tmp.next != null &&*/ !tmp.next.info.equals(existingElem); pred = pred.next, tmp = tmp.next);
    if (tmp != null)
        pred.next = tmp.next;
}
}
public void deleteAfter(T existingElem) {
if(!isInList(existingElem))
System.out.printf("WARNING: Element %s does not exist in the linked list. Insertion failed. \n",(existingElem));
else if (!isEmpty())
if (head == tail && existingElem.equals(head.info)) // if only one
	System.out.println("just 1 element in the list ");       // node on the list;
else if (existingElem.equals(tail.info)) // if more than one node on the list;
	System.out.println("the existing element is the tail of the list");    // and el is in the head node;
else if(existingElem.equals(head.info)) {
	if(head.next == tail) {
		head.next = null;
		head = tail;
	}
	else
		head.next = head.next.next;
	}
else {                    // if more than one node in the list
    SLLNode<T> pred, tmp;// and el is in a nonhead node;
    for (pred = head, tmp = head.next.next; tmp != null && !pred.info.equals(existingElem); pred = pred.next, tmp = tmp.next);
    if (pred.next == tail) {
   	 tail = pred;
   	 pred.next = null;
    }
    else 
   	 pred.next = tmp;
}
}
}