package leetcode;
//given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//For example, S = "this is a test string", T = "tist", Minimum window is "t stri".
import java.util.LinkedList;
import java.util.HashMap;
public class MinimumWindowSubstring {
	//right ,pass all test
	public String minWindow1(String s, String t) {
        HashMap<Character,Integer> dict=new HashMap<Character,Integer>();
		HashMap<Character,Integer> count=new HashMap<Character,Integer>();
		String result="";
		for(int i=0;i<t.length();i++){
		    char c=t.charAt(i);
		    if(!dict.containsKey(c)){
		        dict.put(c,1);
		        count.put(c, 0);
		    }
            else
                dict.put(c,dict.get(c)+1);
		}
		int start=0;
		int end=0;
		int num=dict.size();
		int minlen=Integer.MAX_VALUE;
		for(;start<s.length();start++){
		    char cs=s.charAt(start);
		    if(count.containsKey(cs)){
		        int a=count.get(cs)+1;
		        count.put(cs,a);
		        if(a==dict.get(cs))
		            num--;
		    }
		    while(num==0 && end<=start){
		        if(start-end<minlen){
		            minlen=start-end;
		            result=s.substring(end,start+1);
		        }
		        char ce=s.charAt(end);
		        if(count.containsKey(ce)){
		            int b=count.get(ce);
		            count.put(ce,b-1);
		            if(b==dict.get(ce))
		                num++;
		        }
		        end++;
		    }
		}
		return result;
    }
	
	//wrong answer, cannot pass one test
	public String minWindow(String S, String T){
		HashMap<Character,Integer> dict=new HashMap<Character,Integer>();
		HashMap<Character,Integer> count=new HashMap<Character,Integer>();
		String result="";
		for(int i=0;i<T.length();i++){
			char c=T.charAt(i);
			if(dict.get(c)!=null)
				dict.put(c, dict.get(c)+1);
			else{
				dict.put(c,1);
				count.put(c, 0);
			}
		}
		Integer start=0;
		Integer end=0;
		int standard=0;
		while(end<S.length()){
			char ec=S.charAt(end);
			if(count.containsKey(ec)){
				count.put(ec,count.get(ec)+1);
				if(count.get(ec)==dict.get(ec))
					standard++;
			}
			if(standard==dict.size()){
				while(standard==dict.size()){
					char sc=S.charAt(start);
					if(count.containsKey(sc)){
						count.put(sc,count.get(sc)-1);
						if(count.get(sc)==(dict.get(sc)-1))
							standard--;
					}
					start++;
				}
				if(result.equals("") || result.length()>(end-start+1+1))
					result=S.substring(start-1,end+1);
			}
			end++;
		}
		return(result);
	}
	//wrong answer, wrong understand question
	public String minWindow2(String S, String T){
		int tlen=T.length();
		int slen=S.length();
		LinkedList<Character> queue=new LinkedList<Character>();
		int[] exist=new int[127];
		int minlen=Integer.MAX_VALUE;
		String res="";
		for(int i=0;i<tlen;i++)
			exist[T.charAt(i)]=-1;
		for(int i=0;i<slen;i++){
			char bit=S.charAt(i);
			if(exist[bit]>0){
				if(queue.size()==tlen){
					int len=exist[queue.peek()]-exist[queue.peekLast()];
					if(minlen>len){
						minlen=len;
						res=S.substring(queue.peek()-1,queue.peekLast());
					}
				}
				while(true){
					char quit=queue.poll();
					if(quit==bit){
						queue.offer(bit);
						break;
					}else if(exist[quit]==1)
						exist[quit]=0;
				}
			}
			else if(exist[bit]==-1){
				exist[bit]=i+1;
				queue.offer(bit);
			}
		}
		return res;
	}
	public static void main(String[] args){
		MinimumWindowSubstring minwindow=new MinimumWindowSubstring();
		//System.out.print(minwindow.minWindow("this is a test string", "tist"));
		String S="this is a test string";
		String T="tist";
		System.out.println(minwindow.minWindow(S,T));
		System.out.println(minwindow.minWindow1(S,T));
	}
}
