package ass2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class s201917030_Q2 {
    public static void main(String[] args) throws IOException{
    	String args0 = args[0];
		String args1 = args[1];
		File input = new File(args0);
		File output = new File(args1);
		
		Scanner file = new Scanner(input);
		FileWriter write = new FileWriter(output);
		
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int size = file.nextInt();
        for(int i=0; i<size; i++){
            int num = file.nextInt();
            list.add(num);
        }
        file.close();
        int num1=0, num2=0;
        while(size != num1 && size != num2){
            if (list.get(num2)%2==0) {
                stack.push(list.get(num2));
            }
            else {
                while (num2 > num1) {
                    list.set(num1, stack.pop());
                    num1++;
                }
                num1++;
            }
            num2++;
        }
        if(!stack.empty()){
            while(num2>num1){
                list.set(num1, stack.pop());
                num1++;
            }
        }
        String str ="";
        for(int i=0; i<size; i++)
            str += list.get(i)+" ";
        write.write(str);
        write.close();
    }
}