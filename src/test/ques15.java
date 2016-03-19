package test;

import java.util.Arrays;

public class ques15 {
	StringBuilder solution(StringBuilder str){
		int cha=0;
		int num=0;
		while(str.charAt(num)>='a' && str.charAt(num)<='z')
			num++;
		for(;cha<str.length();cha++){
			while(str.charAt(cha)>='a' && str.charAt(cha)<='z')
				cha++;
			char c=str.charAt(cha);
			str.deleteCharAt(cha);
			if(cha>num)
				str.insert(num-1, c);
			else
				str.insert(num, c);
		}
		return str;
	}
	public static void main(String[] args){
		ques15 Q=new ques15();
        System.out.println(Q.solution(new StringBuilder("a1b2c3")));
	}

}
