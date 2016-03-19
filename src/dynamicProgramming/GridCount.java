package dynamicProgramming;
//ƽ������N��M�����ӣ�ÿ�������з���һ��������ƻ����������Ͻǵĸ��ӿ�ʼ�� ÿһ��ֻ�������߻��������ߣ�ÿ���ߵ�һ�������ϾͰѸ������ƻ���ռ������� ������ȥ����������ռ������ٸ�ƻ����
//��ά��DP����
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
