package ArrayMap;
//Given a list of non negative integers, arrange them such that they form the largest number.
//For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
import java.util.Arrays;

import sort.quicksort;
public class LargestNumber {
	public String largestNumber(int[] nums) {
		sortround(nums, 0, nums.length-1);
		String str=new String();
		for(int i=0;i<nums.length;i++){
			str=str+nums[i];
		}
		while(str.charAt(0)=='0' && str.length()>1){
            str=str.substring(1,str.length());
        }
		return str;
	}
	private static void sortround(int[] nums, int headnum, int tailnum){
		if(headnum>=tailnum)
			return;
		int partitionindex=partition(nums,headnum,tailnum);
		sortround(nums,headnum,partitionindex);
		sortround(nums,partitionindex+1,tailnum);
	}
	public static int partition(int[] nums, int headnum, int tailnum) {
		int pivot=nums[headnum];
		while(headnum<=tailnum){
			while(compare(pivot,nums[headnum]))
				headnum++;
			while(compare(nums[tailnum],pivot))
				tailnum--;
			if(headnum<=tailnum){
				int tmp=nums[headnum];
				nums[headnum]=nums[tailnum];
				nums[tailnum]=tmp;
				headnum++;
				tailnum--;
			}
		}
		return headnum-1;
	}
	private static boolean compare(int a, int b){
		String s1=""+a+b;
		String s2=""+b+a;
		return s1.compareTo(s2)<0;
	}
	public static void main(String[] args){
		LargestNumber LN=new LargestNumber();
		int[] nums={3, 30, 34, 5, 9};
		int[] nums1={0,9,8,7,6,5,4,3,2,1};
		System.out.println(LN.largestNumber(nums));
		System.out.println(Arrays.toString(nums));
		System.out.println(LN.largestNumber(nums1));
		System.out.println(Arrays.toString(nums1));
	}

}
