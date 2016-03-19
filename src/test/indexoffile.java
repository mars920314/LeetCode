package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class indexoffile {
	public String indexoffile(String contents){
		LinkedList<String> result=new LinkedList<String>();
		Map<String,ArrayList> map=new HashMap<String,ArrayList>();
		String[] row=contents.split("\n");
		for(int i=0;i<row.length;i++){
			String[] rowWords= row[i].split(" ");
			for (int j = 0; j < rowWords.length; j++) {
				String word = rowWords[j];
				if (map.containsKey(word)) {
					ArrayList<Integer> rowNumber = map.get(word);
					rowNumber.add(i + 1);
					map.put(word, rowNumber);
				}
				else {
					ArrayList<Integer> rowNumber = new ArrayList<Integer>();
					rowNumber.add(i + 1);
					map.put(word, rowNumber);
				}
			}
		}
		for (String key : map.keySet()) {
			if (result.isEmpty()) {
				result.add(key);
			}
			else {
				for (int j = 0; j < result.size() + 1; j++) {
					if (j == result.size() || key.compareTo(result.get(j)) == -1) {
						result.add(j, key);
						break;
					}
				}
			}
		}
		String str="";
		for(int i=0;i<result.size();i++){
			String word=result.get(i);
			str=str+word;
			ArrayList<Integer> list=map.get(word);
			for(int j=0;j<list.size();j++){
				if(j!=0)
					str=str+",";
				str=str+list.get(j);
			}
		}
		return str;
	}
	public static void main(String args[]){
		String str="My name is a"+"\n"+"my Name is B"+"\n"+"my name1";
		indexoffile IF=new indexoffile();
		System.out.print(IF.indexoffile(str));
	}

}
