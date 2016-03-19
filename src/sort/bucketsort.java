package sort;

import java.util.ArrayList;

//sorting number ranging from 0 to 100
//problem is that array has different no-zero value, but zero, which is not in original array, will participate in sort
public class bucketsort {
	public static void sort(int[] a){
/*		ArrayList<ArrayList> bucket=new ArrayList<ArrayList>();
		int[] bucketcapacity=new int[10];
		for(int i=0;i<a.length;i++){
			ArrayList tmp=new ArrayList();
			tmp.add(a[i]);
		}
*/		
		int[][] bucket=new int[10][a.length];
		int[] bucketcapacity=new int[11];
		for(int i=0;i<a.length;i++){
			bucket[Integer.valueOf(a[i]/10)][bucketcapacity[Integer.valueOf(a[i]/10)]++]=a[i];
		}
		for(int x=0;x<10;x++)
			bubblesort.sort(bucket[x]);	//problem is here
		int i=0;
		for(int x=0;x<11;x++){
			for(int y=0;y<bucketcapacity[x];y++){
				a[i++]=bucket[x][y];
			}
		}
	}
}
