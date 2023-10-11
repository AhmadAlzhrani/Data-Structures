
public class graduate extends student {

	public graduate(int ID, double GPA) {
		super(ID, GPA);
		}

	public String getstatus() {
		if (getGPA() >= 3 && getGPA() <= 4)
			return "good";
		else 
			return "probation";
		
	}

}
