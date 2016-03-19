package leetcode;
//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//Given n = 3, You should return the following matrix:
/*
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
import java.util.Arrays;
public class GenerateMatrix {
	public static int[][] matrix;
	public int index=1;
	public int size;
    public int[][] generateMatrix(int n) {
    	matrix=new int[n][n];
    	size=n;
        for(int loop=0;loop<(size+1)/2;loop++){
        	generateone(loop);
        }
        return matrix;
    }
    public void generateone(int loop){
    	for(int n=loop;n<size-loop;n++)
    		matrix[loop][n]=index++;
    	for(int n=loop+1;n<size-loop;n++)
    		matrix[n][size-loop-1]=index++;
    	for(int n=size-loop-2;n>loop-1;n--)
    		matrix[size-loop-1][n]=index++;
    	for(int n=size-loop-2;n>loop;n--)
    		matrix[n][loop]=index++;
    }
    public static void main(String[] args){
    	int n=0;
    	GenerateMatrix generatematrix=new GenerateMatrix();
    	int[][] a=generatematrix.generateMatrix(n);
    	for(int i=0;i<n;i++)
    		System.out.println(Arrays.toString(a[i]));
    }

}
