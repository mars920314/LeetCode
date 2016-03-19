package string;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int len=0;
		if(s.length()==0)
			return len;
		int[] count=new int[2];
		char a=' ';
		char b=s.charAt(0);
		int lastindex=-1;
		for(int i=1;i<s.length();i++){
			char c=s.charAt(i);
			if(c!=b && c!=a){
				a=b;count[0]=i-(lastindex+1);
				lastindex=i-1;
				b=c;count[1]=1;
				len=Math.max(len, count[0]+count[1]);
			}
			else if(c==a){
				count[0]++;
				lastindex=i;
			}
			else if(c==b)
				count[1]++;
		}
		return Math.max(len, count[0]+count[1]);
	}
	public static void main(String[] args){
		LongestSubstringwithAtMostTwoDistinctCharacters LS=new LongestSubstringwithAtMostTwoDistinctCharacters();
		System.out.print(LS.lengthOfLongestSubstringTwoDistinct("abcdedeefffff"));
	}

}
