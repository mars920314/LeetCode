package string;
//Given an array of strings, group anagrams together.
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list=new ArrayList<List<String>>();
		HashMap<String, Integer> count=new HashMap<String, Integer>();
		Arrays.sort(strs);
		for(String str:strs){
			char[] c=str.toCharArray();
			Arrays.sort(c);
			String sort=new String(c);
			if(count.containsKey(sort)){
				List<String> sublist=list.get(count.get(sort));
				sublist.add(str);
			}else{
				List<String> sublist=new ArrayList<String>();
				sublist.add(str);
				list.add(sublist);
				count.put(sort, list.size()-1);
			}
		}
		return list;
	}

}
