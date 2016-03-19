package datastructure;

public class NumberofIslands {
    private static final int[][] DIRS = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private static final char L = '1', W = '0';

    public void dfsFill(char[][] g, int x, int y) {
        if (x >= 0 && x < g.length && y >= 0 && y < g[0].length && g[x][y] == L) {
            g[x][y] = W;
            for (int[] d : DIRS) dfsFill(g, x + d[0], y + d[1]);
        }
    }

    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == L) {
                    num++;
                    dfsFill(grid, i, j);
                }
            }
        }
        return num;
    }
	public static void main(String[] args){
		char[][] grid={{1,1,1,0},{1,1,0,0},{1,0,0,1},{0,0,1,1}};
		//char[][] grid={{1}};
		NumberofIslands NI=new NumberofIslands();
		System.out.print(NI.numIslands(grid));
	}
}