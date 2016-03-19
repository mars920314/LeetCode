package datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
public class testdata {
	public static void main(String[] args){
		LinkedList<int[]> list3=new LinkedList<int[]>();
		int[] arr1={1,2,3};
		list3.add(arr1);
		int[] arr2=list3.get(0);
		arr2[0]=-1;
		System.out.println(arr1[0]);
		
		System.out.println(10 | 1 & 1);	//from right to left, ans=11; wrong, from left to right ans=1
		Vector<Integer> myVector = new Vector<Integer>();
		myVector.add(1);
		System.out.println(myVector.size());
		System.out.println(myVector.capacity());
		List<String>[] dp = new ArrayList[3];
		char[][] two={{'a','b'},{'c','d'}};
		String twostr=new String(two[0]);
		System.out.println(twostr);
		String xx = "aa"; 
		System.out.println("aab"==(xx+"b"));
		System.out.println(Integer.MAX_VALUE>>13);
		System.out.println(-7>>1);
		System.out.println(3/2);
		int[][] grid=new int[3][4];
		System.out.println(grid[0].length);
		String test=new String();
		test="ab";
		test=test.concat("c");
		test.charAt(0);
		System.out.print(test.charAt(0));
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		System.out.print(array.size());
		array.remove(0);
		System.out.print(array.size());
		System.out.print(array.get(0));
		
		NewHeap heap=new NewHeap(10);
		heap.insert(3);
		heap.insert(5);
		heap.insert(7);
		heap.insert(9);
		
		int[] a={5,6,0,9,4,5,1,7,2,8,11,3};
		NewHeap heap1=new NewHeap(a.length);
		heap1.heapify(a);
		
		NewHeap heap2=new NewHeap(a.length);
		int[] b;
		b=heap2.sort(a);
		System.out.println(Arrays.toString(b));
		
		int[] c=a;
		a[0]=0;
		System.out.println(Arrays.toString(c));
	}

}
