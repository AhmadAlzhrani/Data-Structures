
public class book {
	
	private String title;
	private int pages;
	
	public book(String title, int pages) {
		this.title = title;
		this.pages = pages;
	}
	
	public String gettitle() {
		return title;
	}
	public int getpages() {
		return pages;
	}
	public void ToString() {
		System.out.println( "book: "+title+", # pages: "+pages);
	}

}
