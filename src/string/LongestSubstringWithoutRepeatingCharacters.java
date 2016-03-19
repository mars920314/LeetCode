package string;

//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		int[] order = new int[26];
		int start = 1;
		int letters = 0;
		for (int i = 0; i < len; i++) {
			int x = s.charAt(i) - 'a';
			if (order[x] != 0) {
				letters = Math.max(letters, i + 1 - start);
				start = Math.max(start, order[x] + 1);
				order[x] = i + 1;
			} else {
				order[x] = i + 1;
			}
		}
		if (len == 0)
			return 0;
		letters = Math.max(letters, len + 1 - start);
		return letters;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters LSWRC = new LongestSubstringWithoutRepeatingCharacters();
		String s = "abbadfghja";
		System.out.print(LSWRC.lengthOfLongestSubstring(s));
	}

}
