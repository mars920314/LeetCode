package leetcode;
//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//Do this using only O(n) extra space, where n is the total number of rows in the triangle.
/*
given the following triangle
[
    [2],
   [3,4],
  [6,5,7],
 [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

import java.util.List;
import java.util.ArrayList;
public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle.size()==0)
    		return 0;
    	ArrayList<Integer> min=new ArrayList<Integer>();
    	for(int i=0;i<triangle.size();i++)
    		min.add(i, triangle.get(triangle.size()-1).get(i));
    	for(int layer=triangle.size()-2;layer>-1;layer--)
    		for(int index=0;index<triangle.get(layer).size();index++)
    			min.set(index,triangle.get(layer).get(index)+Math.min(min.get(index), min.get(index+1)));
    	return min.get(0);
    }
    public static void main(String[] args){
    	ArrayList<List<Integer>> triangle=new ArrayList<List<Integer>>();
    	ArrayList<Integer> layer0=new ArrayList<Integer>();
    	ArrayList<Integer> layer1=new ArrayList<Integer>();
    	layer0.add(1);
    	layer1.add(2);
    	layer1.add(3);
    	triangle.add(layer0);
    	triangle.add(layer1);
    	minimumTotal minimumtotal=new minimumTotal();
    	System.out.print(minimumtotal.minimumTotal(triangle));
    }
}
