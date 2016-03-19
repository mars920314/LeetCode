package string;

//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
//and there exists one unique longest palindromic substring.
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int len = s.length();
		int maxlen = -1;
		String str = null;
		if (len == 0)
			return null;
		for (int i = 0; i < len; i++) {
			int sublen = 0;
			while (i - sublen > -1 && i + 1 + sublen < len
					&& s.charAt(i - sublen) == s.charAt(i + 1 + sublen))
				sublen++;
			sublen--;
			if (sublen >= maxlen) {
				maxlen = sublen;
				str = s.substring(i - maxlen, i + 1 + maxlen + 1);
			}
			sublen = 0;
			while (i - sublen > -1 && i + sublen < len
					&& s.charAt(i - sublen) == s.charAt(i + sublen))
				sublen++;
			sublen--;
			if (sublen > maxlen) {
				maxlen = sublen;
				str = s.substring(i - maxlen, i + maxlen + 1);
			}
		}
		return str;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring LPS = new LongestPalindromicSubstring();
		String s = "a";
		System.out.print(LPS.longestPalindrome(s));
	}

}
