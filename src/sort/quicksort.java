package sort;
//This method meet problem when there exist a number that equals to pivot, because they will switch endless.
//This problem due to the pivot switch with the smaller and bigger number instead of saving explicitly and comparing.
//This problem can be solved by Õ¼¿Ó though, which save pivot explicitly then iteratively occupy this empty position
//when detect smaller or bigger number, at last finish one time partition by placing last position with pivot 
import java.util.Arrays;
public class quicksort {
	public static void sort(int[] a){
		sortround(a, 0, a.length-1);
	}
	private static void sortround(int[] a, int headnum, int tailnum){
		if(headnum>=tailnum)
			return;
		int partitionindex=partition(a,headnum,tailnum);
		sortround(a,headnum,partitionindex);
		sortround(a,partitionindex+1,tailnum);
	}
	public static int partition(int[] a, int headnum, int tailnum) {
		int pivot=a[headnum];
		while(headnum<=tailnum){
			while(a[headnum]<pivot)
				headnum++;
			while(a[tailnum]>pivot)
				tailnum--;
			if(headnum<=tailnum){
				int tmp=a[headnum];
				a[headnum]=a[tailnum];
				a[tailnum]=tmp;
				headnum++;
				tailnum--;
			}
		}
		return headnum-1;
	}
	public static void main(String[] args){
		int[] nums={9, 2, 4, 7, 3, 7, 10};
		int[] nums1={0,0,9,8,7,6,5,4,3,2,1};
		quicksort QS=new quicksort();
		QS.sort(nums1);
		System.out.println(Arrays.toString(nums1));
	}
}
