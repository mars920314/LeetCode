package DfsBfs;
//Given a set of distinct integers, nums, return all possible subsets.
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> sets=new ArrayList<List<Integer>>();
		ArrayList<Integer> subset=new ArrayList<Integer>();
		sets.add(subset);
		if(nums.length==0)
			return sets;
		Arrays.sort(nums);
		System.out.print(Arrays.toString(nums));
		for(int i=nums.length-1;i>-1;i--){
			int size=sets.size();
			for(int j=0;j<size;j++){
				ArrayList<Integer> list=new ArrayList<Integer>();
				list.add(nums[i]);
				list.addAll(sets.get(j));
				//integers that might contain duplicates
				if(!sets.contains(list))
					sets.add(list);
			}
			/*
			for(Iterator ite=sets.iterator();ite.hasNext();){
				ArrayList<Integer> list=(ArrayList<Integer>) ite.next();
				list.add(nums[i]);
				sets.add(list);
			}
			*/
		}
		return sets;
	}
	public static void main(String[] args){
		Subsets S=new Subsets();
		int[] nums={1,2,3};
		System.out.print(S.subsets(nums));
	}

}
