
public abstract class student {
	private int ID;
	private double GPA;
	//private String status;
	public student(int ID , double GPA ) {
		this.ID = ID;
		this.GPA = GPA;
		
		
	}
	public int getID() {
		return ID;
	}
	public double getGPA() {
		return GPA;
	}
	public abstract String getstatus();
	
	public String displaystudent() {
		return "ID: "+ID+", GPA: "+String.format("%,.2f",GPA )+", status: "+getstatus();
	}

}
