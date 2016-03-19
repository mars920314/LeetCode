package leetcode;
//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
public class MaxSubArray {
	public int maxSubArray(int[] nums){
		int[] sub=new int[nums.length];
		sub[0]=nums[0];
		for(int i=1;i<nums.length;i++){
			if(sub[i-1]>0)
				sub[i]=sub[i-1]+nums[i];
			else
				sub[i]=nums[i];
		}
		int maxn=0;
		for(int i=0;i<sub.length;i++)
			if(sub[i]>sub[maxn])
				maxn=i;
		return sub[maxn];
	}
	
	public static void main(String[] args){
		MaxSubArray maxsubarray=new MaxSubArray();
		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		System.out.print(maxsubarray.maxSubArray(nums));
	}

}
