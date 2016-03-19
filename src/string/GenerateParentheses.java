package string;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<String>();
		String s = "";
		dfs(list, s, n, n, 2 * n);
		return list;
	}

	void dfs(ArrayList list, String s, int left, int right, int len) {
		if (right < left || left < 0 || right < 0)
			return;
		if (s.length() == len) {
			list.add(s);
			return;
		}
		dfs(list, s.concat("("), left - 1, right, len);
		dfs(list, s.concat(")"), left, right - 1, len);
	}

	public static void main(String[] args) {
		GenerateParentheses GP = new GenerateParentheses();
		System.out.print(GP.generateParenthesis(3));
	}

}
