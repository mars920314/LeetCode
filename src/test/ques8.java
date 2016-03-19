package test;

public class ques8 {
	
	int compare(String col, String s1, String s2){
		char c=col.charAt(0);
		if(s1.charAt(1)==c && s2.charAt(1)!=c)
			return 1;
		else if(s1.charAt(1)!=c && s2.charAt(1)==c)
			return 0;
		else{
			if(s1.charAt(0)>s2.charAt(0))
				return 1;
			else
				return 0;
		}
	}
	public static void main(String args[])
    {
        ques8 Q=new ques8();
        System.out.print(Q.compare("s", "9s", "2H"));
    }

}
