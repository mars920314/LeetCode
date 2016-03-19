package tree;
//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order
import java.util.PriorityQueue;
public class KthLargestElementinanArray {
	//heap
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
		for(int i=0;i<nums.length;i++){
			if(i<k)
				heap.offer(nums[i]);
			else{
				if(heap.peek()<nums[i]){
					heap.poll();
					heap.offer(nums[i]);
				}
			}
		}
		return heap.peek();
	}
	//quick sort
	public int findKthLargest1(int[] nums, int k) {
		return -1;
	}

}
