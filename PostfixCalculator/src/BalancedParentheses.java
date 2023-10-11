
public class BalancedParentheses {
	String str;
	public BalancedParentheses(String str) {
		this.str = str;
	}
	public String balance() {
		String tmp="";
		LabStack<String> stack = new LabStack<String>();
		String open="";
		for(int i= 0; i<str.length(); i++) {
			tmp = str.charAt(i)+"";
			if(tmp.equals("[") | tmp.equals("(") | tmp.equals("{") ) {
				stack.push(tmp);
				open = str;
			}
			else if (tmp.equals("]") | tmp.equals(")") | tmp.equals("}") ) {
				open = stack.pop();
				if((open+tmp).equals("[]") | (open+tmp).equals("()") | (open+tmp).equals("{}"));
				else
					return "expression is not balanced";
			}
		}
		if(stack.isEmpty())
			return "expression is balanced";
		else
			return "expression is not balanced";
	}
}
