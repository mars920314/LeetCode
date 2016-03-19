package ArrayMap;
//Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ¡Ý s. 
//If there isn't one, return 0 instead.
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int start=0;
		int sum=0;
		int len=Integer.MAX_VALUE;
		for(int end=0;end<nums.length;end++){
			sum=sum+nums[end];
			while(sum>=s){
				len=Math.min(len, end-start+1);
				sum=sum-nums[start++];
			}
		}
		if(len==Integer.MAX_VALUE)
			return 0;
		else
			return len;
	}
	public static void main(String[] args){
		MinimumSizeSubarraySum MSSS=new MinimumSizeSubarraySum();
		int[] nums={1,4,4};
		System.out.print(MSSS.minSubArrayLen(4, nums));
	}

}
