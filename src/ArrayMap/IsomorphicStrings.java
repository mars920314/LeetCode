package ArrayMap;
//Given two strings s and t, determine if they are isomorphic.
//For example,Given "egg", "add", return true. Given "foo", "bar", return false. Given "paper", "title", return true.
import java.util.HashMap;
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> forward=new HashMap<Character,Character>();
        HashMap<Character,Character> backward=new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            char ss=s.charAt(i);
            char tt=t.charAt(i);
            if(forward.containsKey(ss)){
            	if(forward.get(ss)!=tt)
                    return false;
            }
            else
                forward.put(ss,tt);
            if(backward.containsKey(tt)){
                if(backward.get(tt)!=ss)
                    return false;
            }
            else
                backward.put(tt,ss);
        }
        return true;
    }
	public static void main(String[] args){
		IsomorphicStrings IS=new IsomorphicStrings();
		System.out.print(IS.isIsomorphic("ab", "aa"));
	}

}
