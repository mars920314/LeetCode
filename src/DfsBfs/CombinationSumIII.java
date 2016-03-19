package DfsBfs;
//Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//Ensure that numbers within the set are sorted in ascending order.
//Input: k = 3, n = 7; Output:[[1,2,4]]	Input: k = 3, n = 9; Output:[[1,2,6], [1,3,5], [2,3,4]]
import java.util.List;
import java.util.ArrayList;
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        putnumber(k,n,1,list,res);
        return res;
    }
    void putnumber(int k, int n, int pos, ArrayList<Integer> list, List<List<Integer>> res){
        if(list.size()>=k){
            if(n==0)
                res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=pos;i<10;i++){
            list.add(i);
            putnumber(k,n-i,i+1,list,res);
            list.remove(list.size()-1);
        }
    }

}
