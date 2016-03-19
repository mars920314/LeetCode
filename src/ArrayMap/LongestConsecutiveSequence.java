package ArrayMap;
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence. Your algorithm should run in O(n) complexity.
//Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
import java.util.HashSet;
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> count=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
            if(!count.contains(nums[i]))
            	count.add(nums[i]);
        int maxlen=0;
        for(int i=0;i<nums.length;i++){
            count.remove(nums[i]);
            int low=1;
            while(count.contains(nums[i]-low)){
                count.remove(nums[i]-low);
                low++;
            }
            int high=-1;
            while(count.contains(nums[i]-high)){
                count.remove(nums[i]-high);
                high--;
            }
            maxlen=Math.max(maxlen,low-high-1);
        }
        return maxlen;
    }
	public static void main(String[] args){
		LongestConsecutiveSequence LCS=new LongestConsecutiveSequence();
		int[] nums={1};
		System.out.print(LCS.longestConsecutive(nums));
	}

}
