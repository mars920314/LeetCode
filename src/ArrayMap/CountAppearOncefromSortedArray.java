package ArrayMap;
//Given a sorted array, remove the elements that appear more than once and return the new length.
//Do not allocate extra space for another array, you must do this in place with constant memory.
public class CountAppearOncefromSortedArray {
	public int appearonce(int[] nums) {
		int len=nums.length;
		if(len==0)
			return 0;
		int diff=0;
		boolean same=false;
		for(int i=1;i<len+1;i++){
			if(i==len || nums[i-1]!=nums[i]){
				if(!same)
					diff++;
				same=false;
			}
			else
				same=true;
		}
		if(len==0)
			diff++;
		return diff;
	}
	//What if duplicates are allowed at most twice?
	public int appeartwice(int[] nums) {
		int len=nums.length;
		if(len==0)
			return 0;
		int diff=0;
		int count=1;
		for(int i=1;i<len+1;i++){
			if(i==len || nums[i-1]!=nums[i]){
				if(count<3)
					diff++;
				count=1;
			}
			else
				count++;
		}
		if(len<2)
			diff++;
		return len-diff;
	}
	public static void main(String[] args){
		CountAppearOncefromSortedArray CAO=new CountAppearOncefromSortedArray();
		int[] nums={1};
		System.out.print(CAO.appearonce(nums));
	}

}
