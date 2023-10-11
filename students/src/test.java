
public class test {

	public static void main(String[] args) {
		for(int i = 0 ; i<5 ; i++ ) {
			 
		 student a1 = new undergraduate((int)(Math.random()*1000000),Math.random()*4);
		 System.out.println(a1.getClass().getName() +" "+a1.displaystudent());
		 student a2 = new graduate((int)(Math.random()*1000000),Math.random()*4);
		 System.out.println(a2.getClass().getName() +" "+a2.displaystudent());
		 
		}
		
		System.out.println("____________________________________________");
		
		book [] books = {new book("eng",10), new Textbook("arabic",190,"ias"), new book("data",770), new Textbook("studies",240,"eng210"),
				new book("title of book",1000), new Textbook("new book",136,"ee233"), new Textbook("random name",550,"chem101"),
				new book("nice book",50), new book("something",900), new book("no name ",1)};
		int book = 0;
		int text = 0;
		for(int i = 0; i<10 ; i++) {
			books[i].ToString();
			if(books[i] instanceof Textbook)
				book+=1;
			else 
				text+=1;		
		}
		System.out.println("number of books: "+book);
		System.out.println("number of textbooks: "+text);
	}

	}


