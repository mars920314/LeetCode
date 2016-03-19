package dynamicProgramming;
//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
//the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
//and it will automatically contact the police if two adjacent houses were broken into on the same night.
//Given a list of non-negative integers representing the amount of money of each house, 
//determine the maximum amount of money you can rob tonight without alerting the police.
public class HouseRobber {
	public int rob(int[] nums){
		int[] dp=new int[nums.length];
		if(nums.length==0)
			return 0;
		for(int i=0;i<nums.length;i++){
			if(i==0)
				dp[0]=nums[0];
			else if(i==1)
				dp[1]=Math.max(nums[0], nums[1]);
			else
				dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		return dp[nums.length-1];
	}
	//This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one
	public int rob1(int[] nums){
		//easy. calcualte twice. firstly, rob nums[0], secondly not rob nums[0]. get the larger one;
		return 0;
	}
	
}
