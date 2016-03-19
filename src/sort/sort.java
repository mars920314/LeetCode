package sort;

public class sort {
//	public static int[] a=new int[10];
	public static int[] a={5,6,0,9,4,5,1,7,2,8,11,3};
	//public static int[] a={5,1,2,3,4,6,7,8};
	public static void main(String args[]){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+",");
		System.out.println(" ");
		//mergesort.sort(a);
		//quicksort.sort(a);
		bucketsort.sort(a);
		//a=heapsort.sort(a);
		//bubblesort.sort(a);
		//testsort.sort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+",");
	}

}
