package DfsBfs;
//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
import java.util.List;
import java.util.ArrayList;
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        //recursive
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        visit(res, list, n, k);
        return res;
    }
    void visit(List<List<Integer>> res, ArrayList<Integer> list, int n, int k){
        if(k==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(list.isEmpty() || (!list.isEmpty() && list.get(list.size()-1)<i+1)){
                list.add(i+1);
                k--;
                visit(res, list, n, k);
                list.remove(list.size()-1);
                k++;
            }
        }
    }
    public static void main(String[] args){
    	Combinations C=new Combinations();
    	System.out.print(C.combine(4,2));
    }

}
