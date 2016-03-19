package sort;
//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
//with the colors in the order red, white and blue.
import java.util.Arrays;
public class SortColors {
	public void sortColors(int[] nums) {
		
	}
	//Given two strings s and t, write a function to determine if t is an anagram of s.
	public boolean isAnagram(String s, String t) {
		byte[] bytes=s.getBytes();
		byte[] bytet=t.getBytes();
		Arrays.sort(bytes);
		Arrays.sort(bytet);
		String ss=new String(bytes);
		String tt=new String(bytet);
		return ss.equals(tt);
	}
	public static void main(String[] args){
		SortColors SC=new SortColors();
		System.out.print(SC.isAnagram("",""));
	}

}
