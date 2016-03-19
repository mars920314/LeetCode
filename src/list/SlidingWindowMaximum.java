package list;

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length==0)
            return new int[0];
		LinkedList<Integer> deque=new LinkedList<Integer>();
		int[] res=new int[nums.length-k+1];
		for(int i=0; i< nums.length;i++){
			if(i>k-1){
				res[i-k]=deque.poll();
			}
			int buffer=0;
			while(!deque.isEmpty() && deque.peekLast()<nums[i]){
				deque.removeLast();
				buffer++;
			}
			while(buffer>-1){
				deque.offer(nums[i]);
				buffer--;
			}
		}
		res[res.length-1]=deque.poll();
		return res;
	}
	public static void main(String[] args){
		SlidingWindowMaximum SWM=new SlidingWindowMaximum();
		int[] nums={1,3,-1,-3,5,3,6,7};
		System.out.print(Arrays.toString(SWM.maxSlidingWindow(nums, 3)));
	}

}
