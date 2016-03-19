package ArrayMap;
//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
//Return the sum of the three integers. You may assume that each input would have exactly one solution.
import java.util.Arrays;
public class the3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int num=target;
		int near=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++){
			int start=0;
			int end=nums.length-1;
			while(start<end){
				if(start==i){
					start++;
					continue;
				}else if(end==i){
					end--;
					continue;
				}
				int sum=nums[start]+nums[end]+nums[i];
				if(sum>target){
					end--;
					if(near>sum-target){
						near=sum-target;
						num=sum;
					}
				}
				else if(sum<target){
					start++;
					if(near>target-sum){
						near=target-sum;
						num=sum;
					}
				}
				else
					return target;
				
			}
		}
		return num;
	}
	public static void main(String[] args){
		the3SumClosest SC=new the3SumClosest();
		int[] nums={0,1,2};
		System.out.print(SC.threeSumClosest(nums, 0));
	}

}
