package devidedConquer;
//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
public class MaximumSubarray {
	//divide and conquer
	public int maxSubArray(int[] nums){
		if(nums==null)
			return 0;
		return subarray(nums, 0, nums.length-1);
	}
	int subarray(int[] nums, int start, int end){
		if(end==start)
			return nums[start];
		int mid=(end-start)/2;
		int left=subarray(nums, start, start+mid);
		int right=subarray(nums, start+mid+1, end);
		return combine(nums, start, end, left, right);
	}
	int combine(int[] nums, int start, int end, int left, int right){
		int max=Math.max(left, right);
		int mid=(end-start)/2;
		int leftsum=0;
		int leftmaxsum=0;
		for(int i=mid-1;i>=start;i--){
			leftsum=leftsum+nums[i];
			leftmaxsum=Math.max(leftmaxsum, leftsum);
		}
		int rightsum=0;
		int rightmaxsum=0;
		for(int i=mid;i<=end;i++){
			rightsum=rightsum+nums[i];
			rightmaxsum=Math.max(rightmaxsum, rightsum);
		}
		return max=Math.max(max, leftsum+rightsum);
	}

}
