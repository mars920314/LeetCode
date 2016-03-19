package sort;

public class bubblesort {
	
	public static void sort(int[] a){
		for(int i=0;i<a.length;i++){
			for(int j=1;j<a.length-i;j++){
				if(a[j]<a[j-1]){
					int tmp=a[j];
					a[j]=a[j-1];
					a[j-1]=tmp;
				}
			}
		}
	}
}
