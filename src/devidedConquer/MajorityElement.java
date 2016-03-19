package devidedConquer;
//Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
//The algorithm should run in linear time and in O(1) space.
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class MajorityElement {
	//divide and conquer
	public int majorityElement(int[] nums) {
		if(nums==null)
			return 0;
		return majority(nums, 0, nums.length-1);
		
	}
	int majority(int[] nums, int start, int end){
		if(end==start)
			return nums[start];
		int mid=(end-start)/2;
		int leftmajor=majority(nums, start, start+mid);
		int rightmajor=majority(nums, start+mid+1, end);
		return combine(nums, start, end, leftmajor, rightmajor);
	}
	int combine(int[] nums, int start, int end, int leftmajor, int rightmajor){
		if(leftmajor==rightmajor)
			return leftmajor;
		int leftnum=0, rightnum=0;
		for(int i=start;i<=end;i++){
			if(nums[i]==leftmajor)
				leftnum++;
			else if(nums[i]==rightmajor)
				rightnum++;
		}
		if(leftnum<rightnum)
			return rightmajor;
		else
			return leftmajor;
	}
	//Moore vote
	public int majorityElement1(int[] nums) {
		int num=nums[0];
		int count=0;
		for(int i=0;i<nums.length-1;i++){
			if(count==0)
				num=nums[i];
			if(num==nums[i])
				count++;
			else
				count--;
		}
		return num;
	}
	//Given an integer array of size n, find all elements that appear more than n/3 times.
	public List<Integer> majorityElement2(int[] nums) {
		List list=new ArrayList<Integer>();
		if(nums.length==0)
			return list;
		if(nums.length==1){
			list.add(nums[0]);
			return list;
		}
		int[] num={nums[0], nums[1]};
		int[] count={0,0};
		for(int i=0;i<nums.length;i++){
			if(count[0]==0)
				num[0]=nums[i];
			else if(count[1]==0)
				num[1]=nums[i];
			if(num[0]==nums[i])
				count[0]++;
			else if(num[1]==nums[i])
				count[1]++;
			else{
				count[0]--;
				count[1]--;
			}
		}
		count[0]=0;
		count[1]=0;
		for(int i=0; i<nums.length;i++){
			if(nums[i]==num[0])
				count[0]++;
			else if(nums[i]==num[1])
				count[1]++;
		}
		if(count[0]>nums.length/3)
			list.add(num[0]);
		if(num[0]!=num[1] && count[1]>nums.length/3)
			list.add(num[1]);
		return list;
	}
	public static void main(String[] args){
		MajorityElement ME=new MajorityElement();
		int[] nums={4,4,4,6,6};
		System.out.print(ME.majorityElement2(nums));
	}

}
