package leetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s){
		s=s.trim();
		s=s.toLowerCase();
		if(s.length()==0)
			return true;
		int len=s.length();
		int start=0;
		int end=len-1;
		while(start!=end && start<len && end>-1){
			char leftchar=s.charAt(start);
			if(!((leftchar<='9' && leftchar>='0') || (leftchar<='z' && leftchar>='a'))){
				start++;
				continue;
			}
			char rightchar=s.charAt(end);
			if(!((rightchar<='9' && rightchar>='0') || (rightchar<='z' && rightchar>='a'))){
				end--;
				continue;
			}
			if(leftchar==rightchar){
				start++;
				end--;
			}
			else
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		ValidPalindrome VP=new ValidPalindrome();
		String s="A man, a plan, a canal: Panama";
		String s1="a.";
		String s2="1a2";
		System.out.print(VP.isPalindrome(s2));
	}

}
