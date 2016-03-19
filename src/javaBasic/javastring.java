package javaBasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class javastring {
	//array
	public static int vec[]=new int[3];
	public static int vec2[]=new int[]{1,2,3};
	//hashmap
	public static HashMap<String, String> hmap=new HashMap<String, String>();
	static{
		hmap.put("0","48");
		hmap.put("A","65");
		hmap.put("a","97");
	}

	public javastring(){
		
	}
	
	public static void main(String[] args){
		javastring jstring=new javastring();
		//hashmap
		Iterator iter=hmap.keySet().iterator(); 
		for(;iter.hasNext();){
			System.out.print(iter.next());
			//System.out.print(hmap.get(iter.next()));
		}
		//arraylist
		ArrayList arr=new ArrayList();
		arr.add("a");
		arr.add("b");
		arr.add("c");
		Iterator iter_arr=arr.iterator();
		for(;iter_arr.hasNext();){
			System.out.print(iter_arr.next());
		}
		for(int i=0;i<3;i++){
			System.out.print(arr.get(i));
		}
		//integer
		Integer num=new Integer(123);
		String str=new String("abcdefg");
		System.out.print(str.charAt(1));
		str=num.toString();
		Float xx=new Float(1.2);
		System.out.print(" WWW "+str.charAt(1));
	}
	
}


