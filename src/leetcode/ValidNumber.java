package leetcode;
//Validate if a given string is numeric.
public class ValidNumber {
	public boolean isNumber(String s) {
        s=s.trim();
        if(s.length()==0)
            return false;
        boolean num=false;
        boolean flag=false;
        boolean exp=false;
        boolean dot=false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='0' && c<='9'){
                num=true;
            }
            else if(c=='.'){
                if(exp || dot)
                    return false;
                dot=true;
            }
            else if(c=='+' || c=='-'){
                if(i!=0 && s.charAt(i-1)!='e')
                    return false;
                if(flag)
                    return false;
                flag=true;
                num=false;
            }
            else if(c=='e'){
                if(exp)
                    return false;
                exp=true;
                dot=false;
                flag=false;
                if(!num)
                    return false;
                else
                    num=false;
            }
            else
                return false;
        }
        return num;
    }

}
