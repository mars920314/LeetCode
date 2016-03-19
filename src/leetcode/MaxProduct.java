package leetcode;
//Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
//nums are Integer, no probability located from 0 to 1;
public class MaxProduct {
	public int maxProduct(int[] nums) {
		int[] pos=new int[nums.length];
		int[] neg=new int[nums.length];
		if(nums==null)
			return 0;
		for(int i=0;i<nums.length;i++){
			if(i==0){
				pos[i]=nums[i];
				neg[i]=nums[i];
			}
			else{
				int a=nums[i]*pos[i-1];
				int b=nums[i]*neg[i-1];
				if(a>b){
					if(a>nums[i])
						pos[i]=a;
					else
						pos[i]=nums[i];
					if(b<nums[i])
						neg[i]=b;
					else
						neg[i]=nums[i];
				}
				else{
					if(b>nums[i])
						pos[i]=b;
					else
						pos[i]=nums[i];
					if(a<nums[i])
						neg[i]=a;
					else
						neg[i]=nums[i];
				}
				//pos[i]=Math.max(nums[i], Math.max(a, b));
				//neg[i]=Math.min(nums[i], Math.min(a, b));
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			max=Math.max(max, Math.max(neg[i], pos[i]));
		}
		return max;
	}
	public static void main(String[] args){
		MaxProduct maxproduct=new MaxProduct();
//		int[] nums={2,3,-2,4};
//		int[] nums={-1,-1};
//		int[] nums={0,0,0};
		int[] nums={-4};
		System.out.print(maxproduct.maxProduct(nums));
	}

}
