package ArrayMap;
//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this in place with constant memory.
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if(nums.length==0)
			return 0;
		int last=0;
		for(int i=1;i<nums.length;i++){
			if(nums[i]!=nums[last]){
				last++;
				nums[last]=nums[i];
			}
		}
		return last+1;
	}
	//What if duplicates are allowed at most twice?
	public int removeDuplicates2(int[] nums) {
		if(nums.length==0)
			return 0;
		int last=0;
		int count=1;
		for(int i=1;i<nums.length;i++){
			if(count<2 || nums[i]!=nums[last]){
				if(nums[i]==nums[i-1])
					count++;
				else
					count=1;
				last++;
				nums[last]=nums[i];
			}
		}
		return last+1;
	}

}
