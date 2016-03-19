package leetcode;
//Given a digit string, return all possible letter combinations that the number could represent.
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
import java.util.ArrayList;
public class LetterCombinations {
	static String[] trans={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result=new ArrayList<String>();
		String buildstring=new String();
		combine(digits,0,buildstring,result);
		return result;
	}
	public void combine(String digits, int index, String buildstring, ArrayList<String> result){
		if(index==digits.length()){
			result.add(buildstring);
			return;
		}
		for(int i=0;i<trans[Integer.parseInt(String.valueOf(digits.charAt(index)))].length();i++){
			String newbuildstring;
				newbuildstring=buildstring.concat(String.valueOf(trans[Integer.parseInt(String.valueOf(digits.charAt(index)))].charAt(i)));
				combine(digits,index+1,newbuildstring,result);
		}
	}
	public static void main(String[] args){
		LetterCombinations letters=new LetterCombinations();
		System.out.println(letters.letterCombinations("23").toString());
	}

}
