package leetcode;
//Given a string s, partition s such that every substring of the partition is a palindrome.
//Return all possible palindrome partitioning of s.
//For example, given s = "aab", Return[ ["aa","b"],  ["a","a","b"] ]
import java.util.List;
import java.util.ArrayList;
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		//recursive DFS
		return new ArrayList<List<String>>();
	}

	//Given a string s, partition s such that every substring of the partition is a palindrome.
	//Return the minimum cuts needed for a palindrome partitioning of s.
	//For example, given s = "aab",Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
	public int minCut(String s) {
		//DP
		return -1;
	}
}
