package list;
import java.util.LinkedList;
public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		LinkedList<Integer> stack=new LinkedList<Integer>();
		int rect=0;
		for(int i=0;i<height.length+1;i++){
			while(!stack.isEmpty() && (i==height.length || height[i]<height[stack.peek()])){
				int j=stack.pop();
				int k=-1;
				if(!stack.isEmpty())
					k=stack.peek();
				int recttmp=(i-(k+1))*height[j];
				rect=Math.max(rect, recttmp);
			}
			stack.push(i);
		}
		return rect;
	}
	public static void main(String[] args){
		LargestRectangleinHistogram LRH=new LargestRectangleinHistogram();
		int[] height={2,1,5,6,2,3};
		int[] height1={5,4,1,2};
		int[] height2={2,4};
		System.out.print(LRH.largestRectangleArea(height1));
	}

}
