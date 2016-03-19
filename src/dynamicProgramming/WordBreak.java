package dynamicProgramming;
//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//For example, given s = "leetcode", dict = ["leet", "code"].
//Return true because "leetcode" can be segmented as "leet code".
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class WordBreak {
	//stupid, but wrong
	public boolean wordBreak1(String s, Set<String> wordDict) {
        if(s==null)
        	return false;
        int start=0;
        int end=0;
        for(;end<s.length();end++){
        	if(wordDict.contains(s.substring(start,end+1)))
        		start=end+1;
        }
        if(start==end)
        	return true;
        else
        	return false;
    }
	//recurrence, but time out
	public boolean wordBreak2(String s, Set<String> wordDict) {
		if(s==null)
        	return false;
		for(int i=0;i<s.length();i++){
			if(wordDict.contains(s.substring(0, i+1)))
				if(i==s.length()-1 || wordBreak2(s.substring(i+1),wordDict))
					return true;
		}
		return false;
	}
	//dynamic programming
	public boolean wordBreak3(String s, Set<String> wordDict) {
		boolean[] dp=new boolean[s.length()+1];
		dp[0]=true;
		for(int i=1;i<s.length()+1;i++){
			for(int j=0;j<i;j++){
				dp[i]=dp[j] && wordDict.contains(s.substring(j,i));
				if(dp[i])
					break;
			}
		}
		return dp[s.length()];
	}
	//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a 
	//valid dictionary word. Return all such possible sentences.
	//s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"]. solution is ["cats and dog", "cat sand dog"].
	//recurrence
	public List<String> wordBreak4(String s, Set<String> wordDict){
		//String str=new String();
		List<String> list=new ArrayList<String>();
		for(int i=0; i<s.length();i++){
			if(wordDict.contains(s.substring(0,i+1))){
				String str=s.substring(0,i+1);
				List<String> sublist=wordBreak4(s.substring(i+1),wordDict);
				if(sublist.size()!=0){
					str=str.concat(" ");
					for(int j=0;j<sublist.size();j++){
						list.add(str.concat(sublist.get(j)).trim());
					}
				}
			}
		}
		if(s.equals(""))
			list.add("");
		return list;
	}
	//dynamic programming
	//就是时间很长，无论什么方法，要遍历时间一定很长，跟求最优解有数量级的差别。除非先做一遍最优解，再根据最优解剪枝。
	public List<String> wordBreak5(String s, Set<String> wordDict){
		List<List<String>> dp=new ArrayList<List<String>>();
		for(int i=0;i<s.length()+1;i++){
			List<String> sublist=new ArrayList<String>();
			for(int j=0;j<i;j++){
				String str=s.substring(j,i);
				if(wordDict.contains(str)){
					str=" ".concat(str);
					for(int k=0;k<dp.get(j).size();k++){
						sublist.add(k,dp.get(j).get(k).concat(str).trim());
					}
				}
			}
			if(i==0)
				sublist.add("");
			dp.add(i,sublist);
		}
		return dp.get(s.length());
	}
	//recurrence+remove duplicate
	public List<String> wordBreak6(String s, Set<String> wordDict){
		boolean[] ipossible=new boolean[s.length()];
		List<String> list=subwordBreak6(s, wordDict, 0, s.length(), ipossible);
		return list;
	}
	public List<String> subwordBreak6(String s, Set<String> wordDict, int start, int end, boolean[] ipossible){
		List<String> list=new ArrayList<String>();
		for(int i=start; i<end;i++){
			if(!ipossible[i] && wordDict.contains(s.substring(start,i+1))){
				String str=s.substring(start,i+1);
				List<String> sublist=subwordBreak6(s,wordDict, i+1, end, ipossible);
				if(sublist.size()!=0){
					str=str.concat(" ");
					for(int j=0;j<sublist.size();j++){
						list.add(str.concat(sublist.get(j)).trim());
					}
				}
				else
					ipossible[i]=true;//remove duplicate here. catsanddot is wrong when reach dot, so it will not search cat+sand & cats+and twice.
			}
		}
		if(start==end)
			list.add("");
		return list;
	}
	public static void main(String[] args){
		WordBreak WB=new WordBreak();
		String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String s4="catsanddog";
		HashSet<String> wordDict=new HashSet();
		wordDict.add("leet");
		wordDict.add("code");
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		wordDict.add("aaaa");
		wordDict.add("aaaaa");
		wordDict.add("aaaaaa");
		wordDict.add("aaaaaaa");
		wordDict.add("aaaaaaaa");
		wordDict.add("aaaaaaaaa");
		wordDict.add("aaaaaaaaaa");
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		//System.out.println(WB.wordBreak4(s4,wordDict));
		List<String> word=new ArrayList<String>();
		word=WB.wordBreak6(s,wordDict);
		for(int i=0;i<word.size();i++)
			System.out.println(word.get(i));
	}

}
