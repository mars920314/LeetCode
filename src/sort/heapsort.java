package sort;

import java.util.Arrays;

public class heapsort {
	public static int[] sort(int[] a){
		buildheap(a);
		int[]b=new int[a.length];
		for(int i=a.length-1;i>0;i--){
			b[i]=a[0];
			a[0]=a[i];
			a[i]=0;
			maxheap(a,0);
		}
		return b;
	}
	public static void buildheap(int[] a){
		for(int i=(a.length-1)/2;i>=0;i--)
			maxheap(a,i);
	}
	public static void maxheap(int[] a, int i){
		int left=2*i+1;
		int right=2*i+2;
		int largest=i;
		if(left<a.length && a[left]>a[largest])
			largest=left;
		if(right<a.length && a[right]>a[largest])
			largest=right;
		if(largest!=i){
			int tmp=a[i];
			a[i]=a[largest];
			a[largest]=tmp;
			maxheap(a,largest);
		}
	}

}
