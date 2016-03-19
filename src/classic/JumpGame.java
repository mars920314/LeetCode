package classic;
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Determine if you are able to reach the last index. A = [2,3,1,1,4], return true.
public class JumpGame {
	public boolean canJump(int[] nums) {
		int max=0;
		for(int i=0;i<nums.length;i++){
			if(max>=i)
				max=Math.max(max,nums[i]+i);
			else
				return false;
		}
		return max>=nums.length-1;
	}
	//Your goal is to reach the last index in the minimum number of jumps.
	//dynamic programming
	public int jump(int[] nums) {
		if(nums.length==0)
			return 0;
		int[] jump=new int[nums.length];
		if(nums[0]>0)
			jump[0]=0;
		else
			return 0;
		for(int i=1;i<nums.length;i++){
			int min=Integer.MAX_VALUE;
			for(int j=0;j<i;j++){
				if(jump[j]+nums[j]>=nums[i])
					min=Math.min(min,jump[j]+1);
			}
			if(min==Integer.MAX_VALUE)
				return -1;
			jump[i]=min;
		}
		return jump[nums.length-1];
	}
	//贪心法可以解，O(n)扫一次就可以了，比DP好得多。因为这道题是最远跳到那么远，而不是只能跳到那么远。如果是后者，引入dp值得。
	//greedy
	public int jump1(int[] nums) {
		int maxindex=0;
        int maxsteps=0;
        int curindex=0;
        for(int i=0;i<nums.length;i++){
            if(i>curindex){
            	if(curindex==maxindex)
            		return -1;
                curindex=maxindex;
                maxsteps++;
            }
            maxindex=Math.max(maxindex, nums[i]+i);
        }
        return maxsteps;
	}
	public static void main(String[] args){
		JumpGame JG=new JumpGame();
		int[] nums={2,0,0,0,1};
		System.out.print(JG.canJump(nums));
		System.out.print(JG.jump1(nums));
	}

}
