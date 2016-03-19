package string;
//Implement a basic calculator to evaluate a simple expression string.
import java.util.LinkedList;
public class BasicCalculator {
//The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
	public int calculate1(String s) {
		LinkedList<Character> expression=new LinkedList<Character>();
		int value=0;
		for(int i=0;i<s.length()+1;i++){
			if(i==s.length() || s.charAt(i)==')'){
				
			}else if(s.charAt(i)<='9' && s.charAt(i)>='0'){
				int a=s.charAt(i++)-'0';
				while(i<s.length() && s.charAt(i)<='9' && s.charAt(i)>='0')
					a=a*10+s.charAt(i++)-'0';
				expression.push((char)a);
			}else
				expression.push(s.charAt(i));
			
			
			if(i!=s.length() && s.charAt(i)!=')')
				expression.push(s.charAt(i));
			else{
				while(!expression.isEmpty()){
					char tmp=expression.pop();
					if(tmp=='(')
						break;
					if(tmp>='0' && tmp<='9'){
						int a=tmp-'0';
						if(!expression.isEmpty() && expression.peek()=='-')
							value=value-a;
						else
							value=value+a;
					}
				}
				expression.push((char)value);
			}
		}
		return value;
	}
//The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
	public int calculate2(String s) {
		return -1;
	}
	public static void main(String[] args){
		BasicCalculator BC=new BasicCalculator();
		String s="(1+(4+5+2)-3)+(6+8)";
		String s1="3-2";
		System.out.print(BC.calculate1(s));
	}
}
