package list;
import java.util.LinkedList;
public class ValidParentheses {
	public boolean isValid(String s) {
		LinkedList<Integer> stack=new LinkedList<Integer>();
		for(int i=0;i<s.length();i++){
			int tmp=0;
			switch(s.charAt(i)){
				case '(':tmp=-1;break;
				case ')':tmp=1;break;
				case '[':tmp=-2;break;
				case ']':tmp=2;break;
				case '{':tmp=-3;break;
				case '}':tmp=3;break;
			}
			if(!stack.isEmpty() && tmp+stack.peek()==0)
				stack.pop();
			else
				stack.push(tmp);
		}
		return stack.isEmpty();
	}

}
