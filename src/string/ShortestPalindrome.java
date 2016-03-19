package string;

import java.util.HashSet;

import java.util.Iterator;

//Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
//Find and return the shortest palindrome you can find by performing this transformation.
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		int len = s.length();
		int index;
		for (int i = len - 1; i > -1; i--) {
			index = i;
			while (i - index < len && index > -1
					&& s.charAt(i - index) == s.charAt(index)
					&& i - index <= index)
				index--;
			index++;
			if (i - index == index || i - index + 1 == index)
				return s.substring(i + 1, len).concat(s);
		}
		HashSet<String> set=new HashSet<String>();
		set.add("d");
		Iterator<String> ite=set.iterator();
		while(ite.hasNext()){
			System.out.print(ite.next());
		}
		
		return null;
	}

	public static void main(String[] args) {
		ShortestPalindrome SP = new ShortestPalindrome();
		String s = "aacecaaa";
		String s1 = "abcd";
		System.out.print(SP.shortestPalindrome(s1));
	}
}
