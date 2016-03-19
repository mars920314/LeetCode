package test;

import java.util.HashMap;

import java.util.Iterator;
public class ques13 {
	int solution(String str){
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put(str, 0);
		boolean flag=true;
		while(flag){
			flag=false;
			HashMap<String, Integer> tmpmap=new HashMap<String, Integer>();
			Iterator iter = map.entrySet().iterator();
			while(iter.hasNext()){
				HashMap.Entry entry = (HashMap.Entry) iter.next();
				String string=(String) entry.getKey();
				//System.out.print(string);
				for(int i=0;i<string.length()-1;i++){
					byte[] array=string.getBytes();
					char tmpbyte=string.charAt(i);
					array[i]=array[i+1];
					array[i+1]=(byte)tmpbyte;
					String tmpstring=new String(array);
					if(!map.containsKey(tmpstring) && !tmpmap.containsKey(tmpstring)){
						flag=true;
						if(tmpstring.contains("2015"))
							return (Integer) entry.getValue()+1;
						else
							tmpmap.put(tmpstring,(Integer) entry.getValue()+1);
					}
				}
			}
			map.putAll(tmpmap);
		}
		return -1;
	}
	public static void main(String[] args){
		ques13 Q=new ques13();
		System.out.print(Q.solution("102125"));
	}

}
