//****************************  DLL.java  *******************************
//                  generic doubly linked list class

public class DLL<T> {
    private DLLNode<T> head, tail;
    public DLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
             return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
             head = new DLLNode<T>(el,head,null);
             head.next.prev = head;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
             tail = new DLLNode<T>(el,null,tail);
             tail.prev.next = tail;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void insertAlternate(DLL<T> newList) {
    	int len1 = 0;
    	int len2 = 0;
    	for (DLLNode<T> tmp = newList.head; tmp != null; tmp = tmp.next)
    		len1++;
    	for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
    		len2++;
    	if(len1==len2) {
    		DLLNode<T> cur=head;
    		
    		
    		for(int i=0; i<len1-1;i++) {
    	
    			DLLNode<T> add = newList.head;
    			newList.head =add.next;
    			add.prev = cur;
    			add.next = cur.next;
    			cur.next.prev = add;
    			cur.next = add;
    			
    			cur = cur.next.next;
    		}
    		addToTail(newList.head.info);		
    	}
    	else
    		System.out.println("different sizes");
    	
    }
    public T deleteFromHead() {
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             head = head.next;
             head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             tail = tail.prev;
             tail.next = null;
        }
        return el;
    }
    public void delete7() {
    	int check = 7;
    	int len = 0;
    	for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
    		len++;
    	if (isEmpty())
    		System.out.println("null");
    	
    	else if(len ==3)
    		deleteFromTail();
    	else {
    		if(check != 0) {
        		for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
        			check--;}
        	DLLNode<T> tmp = tail;
        	if(check != 0) {
        		for (tmp = tail; tmp.prev != null; tmp = tmp.prev) {
        			check--;
        			if(check ==-1)
        				break;
        			}
        		}
        	System.out.println(tmp.info);
        	if(tmp == head)
        		deleteFromHead();
        	else if (tmp==tail)
        		deleteFromTail();
        	else {
        	tmp.prev.next = tmp.next;
        	tmp.next.prev = tmp.prev; 
        	}
        }
    		
    	
    }
    public void printAll() { 
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
             System.out.print(tmp.info + " ");
        System.out.println();
    }
    public void printReverse() {
    	for (DLLNode<T> tmp = tail; tmp != null; tmp = tmp.prev)
            System.out.print(tmp.info + " ");
       System.out.println();
    	
    }
    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
             return null;
        else return tmp.info;
    }
}