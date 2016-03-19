package ArrayMap;
//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
//Find all unique triplets in the array which gives the sum of zero.
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
public class the3Sum {
	//hashmap+bruteforce
	public List<List<Integer>> threeSum(int[] nums) {
		HashMap<Integer,Integer> summap=new HashMap<Integer,Integer>();
		List<List<Integer>> sum=new ArrayList<List<Integer>>();
		
		return sum;
	}
	//sort+two points
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> sum=new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		
		return sum;
	}
	//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> sum=new ArrayList<List<Integer>>();
		
		return sum;
	}

}
