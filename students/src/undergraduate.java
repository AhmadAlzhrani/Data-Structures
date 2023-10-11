
public class undergraduate extends student {

	public undergraduate(int ID, double GPA) {
		super(ID, GPA);
	}

	
	public String getstatus() {
		if (getGPA() >= 3 && getGPA() <= 4)
			return "honor";
		else if (getGPA() >= 2 && getGPA() <= 4)
			return "good";
		else 
			return "probation";
		
	}
}
