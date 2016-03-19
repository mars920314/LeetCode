package dynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//Input: "()(()" Expected: 2
public class LongestValidParentheses {
	//stack
	public int longestValidParentheses(String s) {
        LinkedList<Integer> stack=new LinkedList<Integer>();
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')' && !stack.isEmpty() && s.charAt(stack.peek())=='('){
                stack.pop();
            }
            else{
                if(stack.isEmpty())
                    max=Math.max(max,i);
                else
                    max=Math.max(max,i-stack.peek()-1);
                stack.push(i);
            }
        }
        if(stack.isEmpty())
            max=Math.max(max,s.length());
        else
            max=Math.max(max,s.length()-stack.peek()-1);
        return max;
    }
	//DP
	public int longestValidParentheses1(String s) {
		int[] dp=new int[s.length()+1];
		dp[s.length()]=0;
		for(int i=s.length()-1;i>-1;i--){
			if(i<s.length()-1 && s.charAt(i)=='('){
				if(s.charAt(i+1)==')')
					dp[i]=dp[i+2]+2;
				else if(i+dp[i+1]+1<s.length() && s.charAt(i+dp[i+1]+1)==')'){
					dp[i]=dp[i+1]+2+dp[i+dp[i+1]+2];
					if(i+dp[i+1]+2<dp.length)
						dp[i]=dp[i];
				}
				else
					dp[i]=0;
			}
		}
		int max=0;
		for(int i=0;i<s.length();i++)
			max=Math.max(max, dp[i]);
		System.out.println(Arrays.toString(dp));
		return max;
	}
	public static void main(String[] args){
		String s="()()(())()(";
		String s1="()(()";
		LongestValidParentheses LVP=new LongestValidParentheses();
		System.out.print(LVP.longestValidParentheses1(s1));
	}

}
