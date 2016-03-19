package DfsBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given a collection of numbers, return all possible permutations.
//For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
public class Permutations {
	//recursive, two method to deal with list
	public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        boolean[] isVisited = new boolean[nums.length];
        search(nums,res,list,isVisited);
        return res;
    }
    void search(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> list, boolean[] isVisited){
    	//break condition
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));	//one of deep copy methods
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!isVisited[i]){
                /*one method is to create new list which copy the original one, 克隆一份结果放入递归中
                ArrayList<Integer> listcopy =new ArrayList<Integer>();
                listcopy.addAll(list);
                listcopy.add(nums[i]);	//one of deep copy methods
                */
                //another method is to add and then delete after function call, when add, create new, 保护现场
                list.add(nums[i]);
                isVisited[i]=true;
                search(nums,res,list,isVisited);
                list.remove(list.size()-1);
                isVisited[i]=false;
            }
        }
    }
  //iterate, in each loop add one element at each position then get a copy of it
    public List<List<Integer>> permute1(int[] nums) {
        LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            int size=res.size();
            if(size==0){
                List<Integer> list=new LinkedList<Integer>();
                list.add(nums[0]);
                res.add(list);
            }else
            for(int numlist=0;numlist<size;numlist++){
                List<Integer> list=res.pop();
                for(int numele=0;numele<list.size()+1;numele++){
                    LinkedList<Integer> listcopy=new LinkedList<Integer>(list);
                    listcopy.add(numele,nums[i]);
                    res.add(listcopy);
                }
            }
        }
        return res;
    }

}
