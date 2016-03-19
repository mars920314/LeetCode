package leetcode;
//Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//You are given a target value to search. If found in the array return its index, otherwise return -1. duplicates are allowed.
public class Search {
	public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2;
        while(right-left>1){
            if(nums[mid]==target || nums[left]==target || nums[right]==target)
                return true;
            if(nums[mid]>nums[left]){
                if(nums[left]<target && target<nums[mid])
                    right=mid;
                else
                    left=mid;
            }else if(nums[mid]<nums[left]){
                if(nums[mid]<target && target<nums[right])
                    left=mid;
                else
                    right=mid;
            }else{	//addiction code if duplicates are allowed
                if(nums[mid-1]==nums[mid] && nums[mid+1]!=nums[mid])
                    left=mid;
                else if(nums[mid+1]==nums[mid] && nums[mid-1]!=nums[mid])
                    right=mid;
                else{
                    left++;
                    right--;
                }
            }
            mid=(left+right)/2;
        }
        if(nums[left]==target || nums[right]==target)
            return true;
        else
            return false;
    }

}
