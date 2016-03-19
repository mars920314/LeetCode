package dynamicProgramming;
//A message containing letters from A-Z is being encoded to numbers using the following mapping:'A' -> 1, 'B' -> 2, 'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12). The number of ways decoding "12" is 2.
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length()==0||s==null||s=="0") 
            return 0; 
        int[] decode=new int[s.length()];
        if(isValid(s.substring(0,1))) 
            decode[0]=1;
        else
            return 0;
        for(int i=1;i<s.length();i++){
        	if(isValid(s.substring(i,i+1)))
        		decode[i]=decode[i]+decode[i-1];
        	if(isValid(s.substring(i-1,i+1)))
        		if(i>1)
        			decode[i]=decode[i]+decode[i-2];
        		else
        			decode[i]=decode[i]+1;
        } 
        return decode[s.length()-1];  
    }
    public boolean isValid(String s){  
        if (s.charAt(0)=='0') 
            return false;  
        int code = Integer.parseInt(s);  
        return code>=1 && code<=26;  
    }
    public static void main(String[] args){
    	DecodeWays DW=new DecodeWays();
    	String s="10";
    	System.out.print(DW.numDecodings(s));
    }
}

