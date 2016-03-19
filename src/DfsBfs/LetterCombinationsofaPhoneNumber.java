package DfsBfs;
//Given a digit string, return all possible letter combinations that the number could represent.
import java.util.List;
import java.util.ArrayList;
public class LetterCombinationsofaPhoneNumber {
	static String[] trans={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list=new ArrayList<String>();
        if(digits.length()==0)
            return list;
        dfs(list,"",digits,0);
        return list;
    }
    void dfs(ArrayList list, String str, String digits, int bit){
        if(bit==digits.length()){
            list.add(str);
            return;
        }
        int num=digits.charAt(bit)-'0';
        for(int i=0;i<trans[num].length();i++)
            dfs(list,str+trans[num].charAt(i),digits,bit+1);
    }
    public static void main(String[] args){
    	LetterCombinationsofaPhoneNumber LCP=new LetterCombinationsofaPhoneNumber();
    	System.out.print(LCP.letterCombinations("2"));
    }
}
