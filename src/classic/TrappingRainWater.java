package classic;
import java.util.LinkedList;
public class TrappingRainWater {
	public int trap(int[] height) {
		LinkedList<Integer> stack=new LinkedList<Integer>();
		int contain=0;
		int left=0;
		for(int i=0;i<height.length;i++){
			if(height[i]<left){
				stack.push(height[i]);
			}
			else{
				while(!stack.isEmpty()){
					contain=contain+(left-stack.pop());
				}
				stack.push(height[i]);
				left=height[i];
			}
		}
		int right=0;
		while(!stack.isEmpty()){
			int h=stack.pop();
			if(h<right)
				contain=contain+(right-h);
			else
				right=h;
		}
		return contain;
	}
	public static void main(String[] args){
		TrappingRainWater TRW=new TrappingRainWater();
		int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.print(TRW.trap(height));
	}

}
