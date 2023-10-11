import java.util.Arrays;
import java.util.List;
public class PostfixCalculator {
	String str;
	public PostfixCalculator(String str) {
		this.str = str;
	}
	public void calc() {
		LabStack<String> stack = new LabStack<String>();
		String tmp="";
		int a;
		int b;
		List<String> items = Arrays.asList(str.split(" "));
		System.out.println( items.toString());
		int result = 0;
		for(int i= 0; i<items.size() ; i++) {
			tmp = items.get(i);
			if(Character.isDigit(tmp.charAt(0)))
				stack.push(tmp);
			else if(tmp.equals("+") | tmp.equals("*") | tmp.equals("/") | tmp.equals("-")) {
				try {
					a = Integer.parseInt(stack.pop());
					b = Integer.parseInt(stack.pop());
				}catch(Exception e){
					System.out.println("your postfix expression is not valid");
					break;
				}
				if(tmp.equals("+")) {
					result = b + a; 
					stack.push(result+"");
				}
				else if (tmp.equals("-")) {
					result = b - a; 
					stack.push(result+"");
				}
				else if (tmp.equals("*")) {
					result = b * a; 
					stack.push(result+"");
				}
				else if (tmp.equals("/")) {
					result = b / a; 
					stack.push(result+"");
				}
			}
			System.out.printf("currently the stack is >> %s ",stack.toString());
			System.out.println();
		}
		try {
			tmp = stack.pop();
		}
		catch(Exception e) {}
		if(!stack.isEmpty())
			System.out.println("your postfix expression is not valid");
		else {
			System.out.printf(stack.toString()+" = %d",result);
			System.out.println();
		}
	}
}
