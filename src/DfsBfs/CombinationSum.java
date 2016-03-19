package DfsBfs;
//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, ..., ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ ... ≤ ak).
//The solution set must not contain duplicate combinations.
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
public class CombinationSum {
	//The same repeated number may be chosen from C unlimited number of times.
	List<List<Integer>> combine=new LinkedList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for(int i=candidates.length-1;i>-1;i--){
            LinkedList<Integer> list=new LinkedList<Integer>();
            list.push(candidates[i]);
            dfs(candidates,list,i,target-candidates[i]);
        }
        return combine;
    }
    void dfs(int[] candidates, LinkedList<Integer> list, int maxindex, int target){
        if(target==0){
            combine.add(list);
            return;
        }
        else if(target<0)
            return;
        else{
            for(int i=maxindex;i>-1;i--){
            	//deep copy
            	LinkedList<Integer> copylist=new LinkedList<Integer>();
            	copylist.addAll(list);
            	//shallow copy
            	//LinkedList<Integer> copylist=list;
            	copylist.push(candidates[i]);
                dfs(candidates,copylist,i,target-candidates[i]);
            }
        }
    }
    //Each number in C may only be used once in the combination.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
        for(int i=candidates.length-1;i>-1;i--){
            LinkedList<Integer> list=new LinkedList<Integer>();
            list.push(candidates[i]);
            dfs1(candidates,list,i-1,target-candidates[i]);
        }
        return combine;
    }
    void dfs1(int[] candidates, LinkedList<Integer> list, int maxindex, int target){
        if(target==0 && !combine.contains(list)){
            combine.add(list);
            return;
        }
        else if(target<0)
            return;
        else{
            for(int i=maxindex;i>-1;i--){
            	//deep copy
            	LinkedList<Integer> copylist=new LinkedList<Integer>();
            	copylist.addAll(list);
            	//shallow copy
            	//LinkedList<Integer> copylist=list;
            	copylist.push(candidates[i]);
                dfs1(candidates,copylist,i-1,target-candidates[i]);
            }
        }
    }
    public static void main(String[] args){
    	CombinationSum CS=new CombinationSum();
    	int[] candidates={1};
    	CS.combinationSum(candidates,1);
    }

}
