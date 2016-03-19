package dynamicProgramming;
//平面上有N＊M个格子，每个格子中放着一定数量的苹果。你从左上角的格子开始， 每一步只能向下走或是向右走，每次走到一个格子上就把格子里的苹果收集起来， 这样下去，你最多能收集到多少个苹果。
//二维的DP问题
public class GridCount {
	public int gridcount(int[][] grid){
		int[][] weight=new int[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++){
				if(i==0 && j==0)
					weight[i][j]=grid[i][j];
				else if(i==0 && j!=0)
					weight[i][j]=weight[i][j-1]+grid[i][j];
				else if(i!=0 && j==0)
					weight[i][j]=weight[i-1][j]+grid[i][j];
				else
					weight[i][j]=Math.max(weight[i][j-1],weight[i-1][j])+grid[i][j];
			}
		return weight[grid.length-1][grid[0].length-1];
	}
	public static void main(String[] args){
		GridCount gridcount=new GridCount();
		int[][] grid={{1,2,3},{4,5,6},{7,8,9}};
		System.out.print(gridcount.gridcount(grid));
	}

}
