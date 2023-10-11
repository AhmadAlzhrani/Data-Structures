import java.util.ArrayList;
import java.util.Scanner;
public class mTest {
    public String balancedParentheses(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the mathematical expression");
        String expression = kb.nextLine();
        String temp="";
        LabStack<String> stack = new LabStack<>();
        String temp2;
        int count = 0;
        while(count<expression.length()){
            temp = expression.charAt(count)+"";
            if(temp.equals("[") | temp.equals("(") | temp.equals("{"))
                stack.push(temp);
            else if (temp.equals("]") | temp.equals(")") | temp.equals("}") ) {
                temp2 = stack.pop();
                if(!((temp2+temp).equals("[]") | (temp2+temp).equals("()") | (temp2+temp).equals("{}")))
                    return "Expression is not balanced";
            }
            count++;
        }
        if(stack.isEmpty())
            return "Expression is balanced";
        else {
            return "Expression is not balanced";
            
        }
    }

    public void postfix() {
        LabStack<String> stack = new LabStack<>();
        String temp;
        int first;
        int second;
        ArrayList<String> inputList = new ArrayList<>();
        System.out.println("Enter your input for the postfix method, type done if done");
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        while(!(input.equals("done"))){
            inputList.add(input);
            input = kb.nextLine();
        }
        System.out.println(inputList.toString());
        int result = 0;
        for (int i = 0; i < inputList.size(); i++) {
            temp = inputList.get(i);
            if (Character.isDigit(temp.charAt(0)))
                stack.push(temp);
            else if (temp.equals("+") | temp.equals("*") | temp.equals("/") | temp.equals("-")) {
                    first = Integer.parseInt(stack.pop());
                    second = Integer.parseInt(stack.pop());
                if (temp.equals("+")) {
                    result = second + first;
                    stack.push(result + "");
                } else if (temp.equals("-")) {
                    result = second - first;
                    stack.push(result + "");
                } else if (temp.equals("*")) {
                    result = second * first;
                    stack.push(result + "");
                } else if (temp.equals("/")) {
                    result = second / first;
                    stack.push(result + "");
                }
            }
            System.out.println("currently the stack is>> " + stack.toString());
        }
        if (!stack.isEmpty())
            System.out.println("your postfix expression is not valid");
        else {
            System.out.println(stack.toString() + " " + result);
        }
    }

    public void reverse(){
        ArrayList<String> inputList = new ArrayList<>();
        System.out.println("Enter your input for the reverse method, type done if done");
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        while(!(input.equals("done"))){
            inputList.add(input);
            input = kb.nextLine();
        }
        LabQueue<String> queue = new LabQueue<>();
        for(int i =0 ; i< inputList.size();i++)
            queue.enqueue(inputList.get(i));
        System.out.println("current stack: " +queue.toString());
        LabQueue<String> reverseQueue = new LabQueue<>();
        for(int i=0; i<inputList.size();i++)
            reverseQueue.enqueue(inputList.get(inputList.size()-i-1));
        System.out.println("stack after reverse: "+reverseQueue.toString());
    }
}
