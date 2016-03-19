package sort;

public class mergesort {
	public static void sort(int[] a){
		if(a.length>1){
			int[]left=lefthalf(a);
			int[]right=righthalf(a);
			sort(left);
			sort(right);
			combine(a,left,right);
		}
	}
	private static int[] lefthalf(int[] a){
		int leftlen=a.length/2;
		int[] left=new int[leftlen];
		for(int i=0;i<leftlen;i++)
			left[i]=a[i];
		return left;
	}
	private static int[] righthalf(int[] a){
		int leftlen=a.length/2;
		int rightlen=a.length-leftlen;
		int[] right=new int[rightlen];
		for(int i=0;i<rightlen;i++)
			right[i]=a[leftlen+i];
		return right;
	}
	private static int[] combine(int[] a, int[] left, int[] right){
		int leftnum=0;
		int rightnum=0;
		for(int i=0;i<a.length;i++){
			if(rightnum==right.length){
				a[i]=left[leftnum];
				leftnum++;
			}else if(leftnum==left.length){
				a[i]=right[rightnum];
				rightnum++;
			}else if(left[leftnum]<right[rightnum]){
				a[i]=left[leftnum];
				leftnum++;
			}else if(left[leftnum]>=right[rightnum]){
				a[i]=right[rightnum];
				rightnum++;
			}
		}
		return a;
	}

}
