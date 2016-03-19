package classic;
//Given a sorted array and a target value, return the index if the target is found. 
//If not, return the index where it would be if it were inserted in order.
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int start=0;
        int end=nums.length-1;
        int mid=(start+end)/2;
        while(start<=end){
            if(nums[mid]<target)
                start=mid+1;
            else if(nums[mid]>target){
                if(mid==0 || nums[mid-1]<target)
                    return mid;
                end=mid-1;
            }
            else
                return mid;
            mid=(start+end)/2;
        }
        return start;
    }
	public static void main(String[] args){
		SearchInsertPosition SIP=new SearchInsertPosition();
		int[] nums={1};
		System.out.println(SIP.searchInsert(nums, 2));
	}

}
