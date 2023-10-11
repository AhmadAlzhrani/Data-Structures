
public class Textbook extends book {
	private String course;
	
	public Textbook(String title, int pages, String course) {
		super(title, pages);
		this.course = course;
	}
	
	public String getCourse() {
		return course;
	}
	public void ToString() {
		System.out.println("Text book: "+gettitle()+", # pages: "+getpages()+", Course: "+course);
	}

		
		
}
