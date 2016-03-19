package leetcode;
//Suppose a sorted array is rotated at some pivot unknown to you beforehand. 
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
public class FindMinimuminRotatedSortedArray {
	//You may assume no duplicate exists in the array.
	public int findMin1(int[] nums) {
		if(nums.length==0)
			return 0;
		int low=0;
		int high=nums.length-1;
		int mid=0;
		while(low<high-1){
			mid=(low+high)/2;
			if(nums[mid]<nums[high] && nums[mid]<nums[low]){
				high=mid;
			}
			else if(nums[mid]>nums[high] && nums[mid]>nums[low]){
				low=mid;
			}
			else if(nums[mid]<nums[high] && nums[mid]>nums[low])
				return nums[low];
			else if(nums[mid]>nums[high] && nums[mid]<nums[low])
				return nums[high];
		}
		if(mid+1>nums.length-1)
			return nums[mid];
		return Math.min(nums[mid], nums[mid+1]);
	}
	//The array may contain duplicates.
	//when 3,3,1,3 is happened, high--;
	public int findMin2(int[] nums) {
		if(nums.length==0)
			return 0;
		int low=0;
		int high=nums.length-1;
		int mid=0;
		while(low<high-1){
			mid=(low+high)/2;
			if(nums[mid]<nums[high]){
				high=mid;
			}
			else if(nums[mid]>nums[high]){
				low=mid;
			}
			else
				high--;
		}
		if(mid+1>nums.length-1)
			return nums[low];
		return Math.min(nums[low], nums[low+1]);
	}
	public static void main(String[] args){
		FindMinimuminRotatedSortedArray FMRSA=new FindMinimuminRotatedSortedArray();
		int[] nums={4,5,1,2,3};
		int[] nums1={3,3,1,3};
		System.out.print(FMRSA.findMin2(nums1));
	}

}
