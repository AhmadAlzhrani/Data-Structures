//package lab11;

public class entry<T> {

	private T dataObject;
	private String status;
	private int hashcode;
	
	public entry(T dataObject, String status) {
		this.dataObject = dataObject;
		this.status = status;
		this.hashcode = HashCode(dataObject);		
	}
	public entry(T dataObject) {
		this.dataObject = dataObject;
		this.hashcode = HashCode(dataObject);		
	}
	

	private int HashCode(T dataObject) {
		// TODO Auto-generated method stub
		hashcode = dataObject.hashCode();
		return hashcode;
	}
	public int gethashcode() {
		
		return hashcode;
	}
	
public String getStatus() {
		return status;
	}
public void setStatus(String status) {
	this.status = status;
}

public T getDataObject() {
	return dataObject;
}
@Override
public String toString() {
	
	System.out.println("["+ dataObject +", \'" +status+"\'" + "]");
	return dataObject.toString();
	 }
}
