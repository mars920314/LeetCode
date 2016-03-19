package ArrayMap;
//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if(height.length==0)
			return 0;
		int l=0;
		int r=height.length-1;
		int area=0;
		while(l<r){
			area=Math.max(area, (r-l)*Math.min(height[l], height[r]));
			if(height[l]>height[r])
				r--;
			else if(height[l]<height[r])
				l++;
			else{
				r--;
				l++;
			}
		}
		return area;
	}
	//find the two largest one, but it is wrong
	public int maxArea1(int[] height) {
		if(height.length<2)
			return 0;
		int first=0;
		int second=0;
		for(int i=0;i<height.length;i++){
			if(height[i]>=height[second] || second==0)
				if(height[i]>=height[first]){
					second=first;
					first=i;
				}else
					second=i;
		}
		return height[second]*Math.abs(first-second);
	}
	public static void main(String[] args){
		ContainerWithMostWater CWM=new ContainerWithMostWater();
		int[] height={3,2};
		System.out.print(CWM.maxArea1(height));
	}

}
